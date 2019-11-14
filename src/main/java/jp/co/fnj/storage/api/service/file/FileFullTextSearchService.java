package jp.co.fnj.storage.api.service.file;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.custom.FileMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TFolderMapper;
import jp.co.fnj.storage.api.entity.model.custom.FileAndRelatedFolderInfoEntity;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import jp.co.fnj.storage.api.model.file.FileFullTextSearchRequest;
import jp.co.fnj.storage.api.model.file.FileFullTextSearchResponse;

/**
 * ファイル全文検索APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileFullTextSearchService<REQUEST_BODY extends FileFullTextSearchRequest, RESPONSE extends List<FileFullTextSearchResponse>> {


  @Autowired
  private TFolderMapper tFolderMapper;
  @Autowired
  private FileMapper fileMapper;


  // セッション情報を取得し設定する
  // TODO:未整備のため別途実装
  String developerId = "111";
  String mansionId = "50";
  String userId = "2110031";


  @Transactional(rollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // 該当ファイルList、該当フォルダListを初期化
    List<FileFullTextSearchResponse> applicableFile = new ArrayList<>();
    List<FileFullTextSearchResponse> applicableFolder = new ArrayList<>();

    // リクエストに指定されたフォルダー以下を再帰的に検索し
    // 検索結果を該当ファイルListと該当フォルダListにそれぞれ登録する
    searchKeyword(requestBody.getFolder_id(), requestBody.getSearch_word(), applicableFile,
        applicableFolder);

    // 2つの該当リストをマージ
    List<FileFullTextSearchResponse> responseBodys =
        new ArrayList<>(applicableFolder.size() + applicableFile.size());
    responseBodys.addAll(applicableFolder);
    responseBodys.addAll(applicableFile);
    // レスポンスを返却
    return (RESPONSE) responseBodys;

  }



  /**
   * 指定したフォルダ以下に存在する、検索ワードに該当するファイル・フォルダを検索します.
   * 
   * @param argFolderId
   * @param argSearchWord
   * @param argApplicableFile
   * @param argApplicableFolder
   */
  private void searchKeyword(String argFolderId, String argSearchWord,
      List<FileFullTextSearchResponse> argApplicableFile,
      List<FileFullTextSearchResponse> argApplicableFolder) {

    // TODO: 現状FileSearchからのコピペなので全文検索できるように直す
    // 指定フォルダ直下の検索ワードに該当するファイルを抽出
    List<FileAndRelatedFolderInfoEntity> applicableFiles = fileMapper.selectFileAndRelatedFolder(
        argFolderId, argSearchWord, false, developerId, mansionId, userId);

    // 抽出された結果をレスポンスListに登録
    for (FileAndRelatedFolderInfoEntity file : applicableFiles) {
      FileFullTextSearchResponse item = new FileFullTextSearchResponse();
      item.setFile_file_id(file.getTFile().getFileId());
      item.setFile_folder_id(file.getTFile().getFolderId());
      item.setFile_file_name(file.getTFile().getFileName());
      item.setFile_s3_file_name(file.getTFile().getS3FileName());
      item.setFile_s3_objecrt_key(file.getTFile().getS3ObjectKey());
      item.setFile_file_size(file.getTFile().getFileSize());
      item.setFile_insert_user_id(file.getTFile().getCreateUser());
      item.setFile_insert_date_time(file.getTFile().getCreateDate());
      item.setFile_update_user_id(file.getTFile().getUpdateUser());
      item.setFile_update_date_time(file.getTFile().getUpdateDate());
      argApplicableFile.add(item);
    }


    // 指定フォルダ直下のフォルダの一覧を取得
    TFolderExample folderCriteria = new TFolderExample();

    folderCriteria.createCriteria().andParentFolderIdEqualTo(argFolderId).andDeleteFlgEqualTo(false)
        .andCreateUserEqualTo(userId);
    if (developerId != null) {
      folderCriteria.createCriteria().andDeveloperIdEqualTo(developerId);
    }
    if (mansionId != null) {
      folderCriteria.createCriteria().andMansionIdEqualTo(mansionId);
    }

    folderCriteria.or().andParentFolderIdEqualTo(argFolderId).andDeleteFlgEqualTo(false)
        .andPrivateFlgEqualTo(false);
    if (developerId != null) {
      folderCriteria.createCriteria().andDeveloperIdEqualTo(developerId);
    }
    if (mansionId != null) {
      folderCriteria.createCriteria().andMansionIdEqualTo(mansionId);
    }


    List<TFolder> allFolders = tFolderMapper.selectByExample(folderCriteria);

    // 指定フォルダ直下にフォルダが存在しない場合（＝最下層のディレクトリの場合）は処理終了
    if (allFolders == null) {
      return;
    }

    // 指定フォルダ直下のフォルダを順番に処理
    for (TFolder folder : allFolders) {
      // 検索ワードに該当する場合はレスポンスListに登録
      if (folder.getFolderName().contains(argSearchWord)) {
        FileFullTextSearchResponse item = new FileFullTextSearchResponse();
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
        argApplicableFolder.add(item);
      }

      // 指定フォルダ直下のフォルダの直下を検索（再帰的に検索）
      searchKeyword(folder.getFolderId(), argSearchWord, argApplicableFile, argApplicableFolder);
    }


  }

}
