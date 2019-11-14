package jp.co.fnj.storage.api.controller.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.model.file.FileDownloadRequest;
import jp.co.fnj.storage.api.model.file.FileDownloadResponse;

/**
 * ファイルダウンロードコントローラー.
 *
 **/
@RestController
@Validated
public class FileDownloadController {

  /**
   * ファイルダウンロード.
   *
   * 指定したファイルのダウンロードを行う。 ファイルは複数選択が可能。 フォルダが指定された場合は配下のファイル(フォルダ含む)を全てダウンロードする。
   * ダウンロード対象が複数存在する場合、圧縮してダウンロードする。
   *
   * @param targets ダウンロード対象リスト
   * @return FileUpdateResponse ファイル検索結果
   */
  @RequestMapping(value = "/download", method = RequestMethod.GET) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<FileDownloadResponse> fileupdate(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileDownloadRequest requestBody) {

    // レスポンスを返却
    FileDownloadResponse res = new FileDownloadResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(res, headers, HttpStatus.OK);
  }

}
