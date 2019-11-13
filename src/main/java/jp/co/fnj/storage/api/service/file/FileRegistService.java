package jp.co.fnj.storage.api.service.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TFileMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TFolderMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.file.FileRegistRequest;
import jp.co.fnj.storage.api.model.file.FileRegistResponse;
import jp.co.fnj.storage.api.model.file.S3FileNameCheckRequest;
import jp.co.fnj.storage.api.model.file.S3FileNameCheckResponse;

/**
 * ファイル登録APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileRegistService<REQUEST_BODY extends FileRegistRequest, RESPONSE extends FileRegistResponse> {

  @Autowired
  private TFolderMapper tFolderMapper;

  @Autowired
  private TFileMapper tFileMapper;

  @Autowired
  private TSortOrderMapper tSortOrderMapper;

  @Autowired
  private S3FileNameCheckService<S3FileNameCheckRequest, S3FileNameCheckResponse> s3FileNameCheckService;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // ファイルオブジェクトの生成
    byte[] contentBytes =
        Base64.getMimeDecoder().decode(requestBody.getUpload_file().split(",")[1]);
    // どんな形式でオブジェクト化するかはS3登録サービス出来てからIFに合わせる
    try (FileOutputStream imageOutFile =
        new FileOutputStream("C:/appbox/" + requestBody.getFile_name())) {
      imageOutFile.write(contentBytes);
      imageOutFile.close();
    } catch (IOException e) {
      throw new StorageRuntimeException(Messages.E02022, e);
    }
    // TODO セッション情報の取得
    String developerId = null;
    String mansionId = null;
    String userId = null;

    // 保存先フォルダ情報の取得
    TFolderExample folderCriteria = new TFolderExample();
    folderCriteria.createCriteria().andFolderIdEqualTo(requestBody.getFolder_id())
        .andDeveloperIdEqualTo(developerId).andMansionIdEqualTo(mansionId)
        .andDeleteFlgEqualTo(false);
    TFolder putFolder = tFolderMapper.selectByExample(folderCriteria).get(0);
    // TODO ファイルの論理重複チェックを呼ぶ

    // TODO ファイルの物理重複チェックを呼ぶ
    S3FileNameCheckRequest input = new S3FileNameCheckRequest();
    input.setFile_id(null);
    input.setFolder_id(putFolder.getFolderId());
    input.setS3_file_name(requestBody.getFile_name());
    if (s3FileNameCheckService.execute(request, response, input).getCheck_rslt()) {
      // 重複あり
    }

    // TODO 重複があった場合はファイルテーブルの更新、重複はエラーにするかも？
    // TODO 権限チェックを行っている前提でデベID、マンションIDの一致確認サボる。Generatorつかう

    // TODO 重複があった場合は全文検索テーブルの削除、重複はエラーにするかも？


    // ファイルテーブルへ新規登録
    // TODO ファイルID採番
    String newFileId = "NEW_FILE_ID001";
    TFile insertEntity = new TFile();
    insertEntity.setFileName(newFileId);
    insertEntity.setFolderId(requestBody.getFolder_id());
    insertEntity.setFileName(requestBody.getFile_name());
    insertEntity.setS3FileName(requestBody.getFile_name());
    insertEntity.setDeleteFlg(false);
    insertEntity.setS3ObjectKey(putFolder + "/" + requestBody.getFile_name());
    insertEntity.setFileSize(60L); // TODO
    insertEntity.setFullTextType(false);
    insertEntity.setCreateUser(userId);
    insertEntity.setCreateDate(LocalDateTime.now());
    tFileMapper.insertSelective(insertEntity);

    // TODO ソート順登録サービスよぶ

    // TODO S3ファイル登録サービスを呼ぶ


    return (RESPONSE) new FileRegistResponse();
  }

}
