package jp.co.fnj.storage.api.service.viewer;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.generat.TFileMapper;
import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFileExample;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.viewer.FileExtensionCheckRequest;
import jp.co.fnj.storage.api.model.viewer.FileExtensionCheckResponse;
import jp.co.fnj.storage.api.util.AwsS3Util;

/**
 * ファイル拡張子チェックサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileExtensionCheckService<REQUEST_BODY extends FileExtensionCheckRequest, RESPONSE extends FileExtensionCheckResponse> {

  /** ファイルテーブルマッパー */
  @Autowired
  TFileMapper tFileMapper;

  @Autowired
  AwsS3Util awsS3Util;

  @Transactional(rollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // ファイルIDをもとに、ファイルテーブルを取得する。
    TFileExample tFileExample = new TFileExample();
    tFileExample.createCriteria().andFileIdEqualTo(requestBody.getFile_id())
        .andDeleteFlgEqualTo(false);
    tFileExample.setForUpdate(true);
    List<TFile> listFileExample = tFileMapper.selectByExample(tFileExample);
    TFile File = listFileExample.get(0);

    String FilePath = File.getS3ObjectKey();

    String Extension = null;
    try {
      Extension = awsS3Util.getContentType(FilePath);
    } catch (Exception e) {
      throw new StorageRuntimeException("拡張子取得エラー", e);
    }

    FileExtensionCheckResponse responseBodys = new FileExtensionCheckResponse();
    int display_type;
    // TODO 必要があれば追加する。
    switch (Extension) {
      /** 表示種別(1:txt,2:pdf,3:img,4:audio,5:video,6:それ以外) */
      case "text/plain":
        display_type = 1;
        break;
      case "application/pdf":
        display_type = 2;
        break;
      case "image/jpeg":
      case "image/gif":
      case "image/png":
      case "image/bmp":
        display_type = 3;
        break;
      case "audio/wave":
      case "audio/mpeg":
      case "audio/x-aac":
        display_type = 4;
        break;
      case "video/mp4":
        // .mov
      case "video/quicktime":
      case "video/webm":
        display_type = 5;
        break;
      default:
        display_type = 6;
    }

    responseBodys.setExtension(Extension);
    responseBodys.setDisplay_type(display_type);

    return (RESPONSE) responseBodys;
  }
}
