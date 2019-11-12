package jp.co.fnj.storage.api.controller.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.model.file.FileRegistRequest;
import jp.co.fnj.storage.api.model.file.FileRegistResponse;

/**
 * ファイル登録APIコントローラー.
 *
 **/
@RestController
@Validated
public class FileRegistController {

  /**
   * 
   * ファイル登録API.
   * 
   * @return
   */
  @RequestMapping(value = "/lib/fileupload", method = RequestMethod.POST) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<FileRegistResponse> fileRegist(HttpServletRequest request,
      HttpServletResponse response, @RequestBody FileRegistRequest requestBody) {

    // レスポンスを返却
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}
