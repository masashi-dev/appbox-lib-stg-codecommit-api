package jp.co.fnj.storage.api.service.file;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.generat.TFileMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TFolderMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFileExample;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrderExample;
import jp.co.fnj.storage.api.model.file.FileGetListRequest;
import jp.co.fnj.storage.api.model.file.FileGetListResponse;

/**
 * ファイル一覧取得APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileGetListService<REQUEST_BODY extends FileGetListRequest, RESPONSE extends List<FileGetListResponse>> {

  @Autowired
  private TFolderMapper tFolderMapper;

  @Autowired
  private TFileMapper tFileMapper;

  @Autowired
  private TSortOrderMapper tSortOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // TODO セッション情報を取得し設定する
    String developerId = null;
    String mansionId = null;
    String userId = null;

    TFolderExample folderCriteria = new TFolderExample();
    folderCriteria.createCriteria().andFolderGroupIn(List.of(1, 2, 3, 4, 5, 6))
        .andDeveloperIdEqualTo(developerId).andMansionIdIn(List.of(mansionId))
        .andParentFolderIdEqualTo(requestBody.getFolder_id()).andDeleteFlgEqualTo(false)
        .andPrivateFlgEqualTo(false);
    TFolderExample.Criteria fCriteria = folderCriteria.createCriteria()
        .andFolderGroupIn(List.of(1, 2, 3, 4, 5, 6)).andDeveloperIdEqualTo(developerId)
        .andMansionIdIn(List.of(mansionId)).andParentFolderIdEqualTo(requestBody.getFolder_id())
        .andDeleteFlgEqualTo(false).andCreateUserEqualTo(userId);
    folderCriteria.or(fCriteria);
    List<TFolder> tFolders = tFolderMapper.selectByExample(folderCriteria);


    TFileExample fileCriteria = new TFileExample();
    fileCriteria.createCriteria().andFolderIdEqualTo(requestBody.getFolder_id())
        .andDeleteFlgEqualTo(false);
    List<TFile> tFiles = tFileMapper.selectByExample(fileCriteria);


    TSortOrderExample folderSortCriteria = new TSortOrderExample();
    List<String> folderIds =
        tFolders.stream().map(TFolder::getFolderId).collect(Collectors.toList());
    folderSortCriteria.createCriteria().andParentFolderIdEqualTo(requestBody.getFolder_id())
        .andFolderIdIn(folderIds);
    List<TSortOrder> folderSorts = tSortOrderMapper.selectByExample(folderSortCriteria);


    TSortOrderExample fileSortCriteria = new TSortOrderExample();
    List<String> fileIds = tFiles.stream().map(TFile::getFileId).collect(Collectors.toList());
    fileSortCriteria.createCriteria().andParentFolderIdEqualTo(requestBody.getFolder_id())
        .andFileIdIn(fileIds);
    List<TSortOrder> fileSorts = tSortOrderMapper.selectByExample(fileSortCriteria);

    List<FileGetListResponse> responseBodys = new ArrayList<>(tFolders.size() + tFiles.size());
    // フォルダと表示順をマージしながらレスポンスListを作成
    tFolders.forEach(folder -> {
      TSortOrder tSortOrder = folderSorts.stream()
          .filter(s -> s.getFolderId().equals(folder.getFolderId())).findFirst().get();

      TFolder currentFolder = tFolderMapper.selectByPrimaryKey(requestBody.getFolder_id());

      FileGetListResponse item = new FileGetListResponse();
      item.setCurrent_folder_name(currentFolder.getFolderName());
      item.setFolder_folder_id(folder.getFolderId());
      item.setFolder_parent_folder_id(folder.getParentFolderId());
      item.setFolder_folder_name(folder.getFolderName());
      item.setFolder_s3_folder_name(folder.getS3FolderName());
      item.setFolder_developer_id(folder.getDeveloperId());
      item.setFolder_mansion_id(folder.getMansionId());
      item.setFolder_s3_object_key(folder.getS3ObjectKey());
      item.setFolder_explanatory_text(folder.getExplanatoryText());
      item.setFolder_insert_user_id(folder.getCreateUser());
      item.setFolder_insert_date_time(folder.getCreateDate());
      item.setFolder_update_user_id(folder.getUpdateUser());
      item.setFolder_update_date_time(folder.getUpdateDate());
      item.setSort_order(tSortOrder.getSortOrder());

      responseBodys.add(item);
    });

    // ファイルと表示順をマージしながらレスポンスListを作成
    tFiles.forEach(file -> {
      TSortOrder tSortOrder =
          fileSorts.stream().filter(s -> s.getFileId().equals(file.getFileId())).findFirst().get();

      FileGetListResponse item = new FileGetListResponse();
      item.setFile_file_id(file.getFileId());
      item.setFile_folder_id(file.getFolderId());
      item.setFile_file_name(file.getFileName());
      item.setFile_s3_file_name(file.getS3FileName());
      item.setFile_s3_objecrt_key(file.getS3ObjectKey());
      item.setFile_file_size(file.getFileSize());
      item.setFile_insert_user_id(file.getCreateUser());
      item.setFile_insert_date_time(file.getCreateDate());
      item.setFile_update_user_id(file.getUpdateUser());
      item.setFile_update_date_time(file.getUpdateDate());
      item.setSort_order(tSortOrder.getSortOrder());

      responseBodys.add(item);
    });

    // 全体を表示順にソートして返却
    responseBodys.sort(Comparator.comparing(FileGetListResponse::getSort_order));
    return (RESPONSE) responseBodys;
  }

}
