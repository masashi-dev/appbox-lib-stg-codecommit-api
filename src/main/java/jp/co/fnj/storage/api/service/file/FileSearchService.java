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
 * ファイル検索APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileSearchService<REQUEST_BODY extends FileGetListRequest, RESPONSE extends List<FileGetListResponse>> {


  @Autowired
  private TFolderMapper tFolderMapper;

  @Autowired
  private TFileMapper tFileMapper;

  @Autowired
  private TSortOrderMapper tSortOrderMapper;


  // TODO:Listの型を適切にする
  /** 該当ファイルList */
  List<FileGetListResponse> applicableFile = new ArrayList<>();
  /** 該当フォルダList */
  List<FileGetListResponse> applicableFolder = new ArrayList<>();


  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // セッション情報を取得し設定する
    // TODO:未整備のため別途実装
    String developerId = null;
    String mansionId = null;
    String userId = null;

    // リクエストに指定されたフォルダー以下を再帰的に検索し
    // 検索結果を該当ファイルListと該当フォルダListにそれぞれ登録する
    searchKeyword(requestBody.getFolder_id(), "test"); // TODO;キーワードを動的にする

    // 該当ファイルListをソート

    // 該当フォルダListをソート

    // 2つの該当リストをマージしレスポンスListを作成
    // 該当フォルダ→該当ファイルの並び順


    // レスポンスを返却
    List<FileGetListResponse> responseBodys =
        new ArrayList<>(applicableFolder.size() + applicableFile.size());
    responseBodys.sort(Comparator.comparing(FileGetListResponse::getSort_order));
    return (RESPONSE) responseBodys;


    // // フォルダの検索結果をソート
    // TSortOrderExample folderSortCriteria = new TSortOrderExample();
    // List<String> folderIds =
    // tFolders.stream().map(TFolder::getFolderId).collect(Collectors.toList());
    // folderSortCriteria.createCriteria().andParentFolderIdEqualTo(requestBody.getFolder_id())
    // .andFolderIdIn(folderIds);
    // List<TSortOrder> folderSorts = tSortOrderMapper.selectByExample(folderSortCriteria);
    //
    // // ファイルの検索結果をソート
    // TSortOrderExample fileSortCriteria = new TSortOrderExample();
    // List<String> fileIds = tFiles.stream().map(TFile::getFileId).collect(Collectors.toList());
    // fileSortCriteria.createCriteria().andParentFolderIdEqualTo(requestBody.getFolder_id())
    // .andFileIdIn(fileIds);
    // List<TSortOrder> fileSorts = tSortOrderMapper.selectByExample(fileSortCriteria);
    //
    //
    // // フォルダと表示順をマージしながらレスポンスListを作成
    // List<FileGetListResponse> responseBodys = new ArrayList<>(tFolders.size() + tFiles.size());
    // tFolders.forEach(folder -> {
    // TSortOrder tSortOrder = folderSorts.stream()
    // .filter(s -> s.getFolderId().equals(folder.getFolderId())).findFirst().get();
    //
    // FileGetListResponse item = new FileGetListResponse();
    // item.setFolder_folder_id(folder.getFolderId());
    // item.setFolder_parent_folder_id(folder.getParentFolderId());
    // item.setFolder_folder_name(folder.getFolderName());
    // item.setFolder_s3_folder_name(folder.getS3FolderName());
    // item.setFolder_developer_id(folder.getDeveloperId());
    // item.setFolder_mansion_id(folder.getMansionId());
    // item.setFolder_s3_object_key(folder.getS3ObjectKey());
    // item.setFolder_explanatory_text(folder.getExplanatoryText());
    // item.setFolder_insert_user_id(folder.getCreateUser());
    // item.setFolder_insert_date_time(folder.getCreateDate());
    // item.setFolder_update_user_id(folder.getUpdateUser());
    // item.setFolder_update_date_time(folder.getUpdateDate());
    // item.setSort_order(tSortOrder.getSortOrder());
    //
    // responseBodys.add(item);
    // });
    //
    //
    // // ファイルと表示順をマージしながらレスポンスListを作成
    // tFiles.forEach(file -> {
    // TSortOrder tSortOrder =
    // fileSorts.stream().filter(s -> s.getFileId().equals(file.getFileId())).findFirst().get();
    //
    // FileGetListResponse item = new FileGetListResponse();
    // item.setFile_file_id(file.getFileId());
    // item.setFile_folder_id(file.getFolderId());
    // item.setFile_file_name(file.getFileName());
    // item.setFile_s3_file_name(file.getS3FileName());
    // item.setFile_s3_objecrt_key(file.getS3ObjectKey());
    // item.setFile_file_size(file.getFileSize());
    // item.setFile_insert_user_id(file.getCreateUser());
    // item.setFile_insert_date_time(file.getCreateDate());
    // item.setFile_update_user_id(file.getUpdateUser());
    // item.setFile_update_date_time(file.getUpdateDate());
    // item.setSort_order(tSortOrder.getSortOrder());
    //
    // responseBodys.add(item);
    // });
    //
    // // 全体を表示順にソートして返却
    // responseBodys.sort(Comparator.comparing(FileGetListResponse::getSort_order));
    // return (RESPONSE) responseBodys;
  }



  /**
   * 指定したフォルダ以下に存在する、キーワードに該当するファイル・フォルダを検索します.
   * 
   * @param argParentFolderId
   * @param argKeyword
   */
  private void searchKeyword(String argParentFolderId, String argKeyword) {

    // 親フォルダ直下のキーワードに該当するファイルを抽出
    TFileExample fileCriteria = new TFileExample();
    fileCriteria.createCriteria().andFolderIdEqualTo(argParentFolderId).andDeleteFlgEqualTo(false); // TODO:Like条件を実装する
    List<TFile> applicableFiles = tFileMapper.selectByExample(fileCriteria);

    // 抽出された結果をレスポンスListに登録
    for (TFile file : applicableFiles) {
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
      // item.setSort_order(tSortOrder.getSortOrder()); // TODO:表示順の付番は別途考える
      applicableFile.add(item);
    }


    // 親フォルダ直下のフォルダの一覧を取得
    TFolderExample folderCriteria = new TFolderExample();
    folderCriteria.createCriteria().andParentFolderIdEqualTo(argParentFolderId)
        .andDeleteFlgEqualTo(false); // TODO:条件を見直す
    List<TFolder> allFolders = tFolderMapper.selectByExample(folderCriteria);

    // 親フォルダ直下にフォルダが存在しない場合（＝最下層のディレクトリの場合）は処理終了
    if (allFolders == null) {
      return;
    }

    // 親フォルダ直下のフォルダを順番に処理
    for (TFolder folder : allFolders) {
      // キーワードに該当する場合はレスポンスListに登録
      if (folder.getFolderName().contains(argKeyword)) {
        FileGetListResponse item = new FileGetListResponse();
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
        // item.setSort_order(tSortOrder.getSortOrder()); // TODO:表示順の付番は別途考える
        applicableFolder.add(item);
      }

      // 親フォルダ直下のフォルダの直下を検索（再帰的に検索）
      searchKeyword(folder.getFolderId(), argKeyword);
    }


  }

}
