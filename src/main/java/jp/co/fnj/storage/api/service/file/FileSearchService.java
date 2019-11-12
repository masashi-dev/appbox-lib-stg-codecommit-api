package jp.co.fnj.storage.api.service.file;

import java.util.ArrayList;
import java.util.List;
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
import jp.co.fnj.storage.api.model.file.FileSearchRequest;
import jp.co.fnj.storage.api.model.file.FileSearchResponse;

/**
 * ファイル検索APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileSearchService<REQUEST_BODY extends FileSearchRequest, RESPONSE extends List<FileSearchResponse>> {


  @Autowired
  private TFolderMapper tFolderMapper;

  @Autowired
  private TFileMapper tFileMapper;

  @Autowired
  private TSortOrderMapper tSortOrderMapper;


  /** 該当ファイルList */
  List<FileSearchResponse> applicableFile;
  /** 該当フォルダList */
  List<FileSearchResponse> applicableFolder;


  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // セッション情報を取得し設定する
    // TODO:未整備のため別途実装
    String developerId = null;
    String mansionId = null;
    String userId = null;

    // 該当ファイルList、該当フォルダListを初期化
    applicableFile = new ArrayList<>();
    applicableFolder = new ArrayList<>();

    // リクエストに指定されたフォルダー以下を再帰的に検索し
    // 検索結果を該当ファイルListと該当フォルダListにそれぞれ登録する
    searchKeyword(requestBody.getFolder_id(), requestBody.getSearch_word());

    // 2つの該当リストをマージ
    List<FileSearchResponse> responseBodys =
        new ArrayList<>(applicableFolder.size() + applicableFile.size());
    responseBodys.addAll(applicableFolder);
    responseBodys.addAll(applicableFile);
    // レスポンスを返却
    return (RESPONSE) responseBodys;

  }



  /**
   * 指定したフォルダ以下に存在する、キーワードに該当するファイル・フォルダを検索します.
   * 
   * @param argFolderId
   * @param argKeyword
   */
  private void searchKeyword(String argFolderId, String argKeyword) {

    // 指定フォルダ直下のキーワードに該当するファイルを抽出
    TFileExample fileCriteria = new TFileExample();
    fileCriteria.createCriteria().andFolderIdEqualTo(argFolderId).andDeleteFlgEqualTo(false)
        .andFileNameLike("%" + argKeyword + "%");
    List<TFile> applicableFiles = tFileMapper.selectByExample(fileCriteria);

    // 抽出された結果をレスポンスListに登録
    for (TFile file : applicableFiles) {
      FileSearchResponse item = new FileSearchResponse();
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
      applicableFile.add(item);
    }


    // 指定フォルダ直下のフォルダの一覧を取得
    TFolderExample folderCriteria = new TFolderExample();
    folderCriteria.createCriteria().andParentFolderIdEqualTo(argFolderId)
        .andDeleteFlgEqualTo(false); // TODO:条件を見直す
    List<TFolder> allFolders = tFolderMapper.selectByExample(folderCriteria);

    // 指定フォルダ直下にフォルダが存在しない場合（＝最下層のディレクトリの場合）は処理終了
    if (allFolders == null) {
      return;
    }

    // 指定フォルダ直下のフォルダを順番に処理
    for (TFolder folder : allFolders) {
      // キーワードに該当する場合はレスポンスListに登録
      if (folder.getFolderName().contains(argKeyword)) {
        FileSearchResponse item = new FileSearchResponse();
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
        applicableFolder.add(item);
      }

      // 指定フォルダ直下のフォルダの直下を検索（再帰的に検索）
      searchKeyword(folder.getFolderId(), argKeyword);
    }


  }

}
