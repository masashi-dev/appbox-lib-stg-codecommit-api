package jp.co.fnj.storage.api.controller.viewer;

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
import jp.co.fnj.storage.api.model.viewer.FileExtensionCheckRequest;
import jp.co.fnj.storage.api.model.viewer.FileExtensionCheckResponse;

/**
 * ファイル拡張子チェックコントローラー.
 *
 **/
@RestController
@Validated
public class FileExtensionCheckController {

  /**
   * ファイル拡張子チェック.
   *
   * ファイルの拡張子を確認し返却します。
   *
   * @param file_id ファイルID
   * @return FileExtensionCheckResponse ファイル検索結果
   */
  @RequestMapping(value = "/fileextcheck", method = RequestMethod.GET) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<FileExtensionCheckResponse> extensionCheck(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileExtensionCheckRequest requestBody) {

    // レスポンスを返却
    FileExtensionCheckResponse res = new FileExtensionCheckResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(res, headers, HttpStatus.OK);
  }

}
