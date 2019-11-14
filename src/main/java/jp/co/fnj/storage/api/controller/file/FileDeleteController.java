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
import jp.co.fnj.storage.api.model.file.FileDeleteRequest;
import jp.co.fnj.storage.api.model.file.FileDeleteResponse;

/**
 * ファイル/フォルダ削除コントローラー.
 *
 **/
@RestController
@Validated
public class FileDeleteController {

  /**
   * ファイル/フォルダ削除.
   *
   * 指定したファイル/フォルダの削除を行う。 ファイル/フォルダは複数選択が可能。 フォルダが指定された場合は配下のファイル(フォルダ含む)を全て削除する。
   *
   * @param targets 削除対象リスト
   * @return FileDeleteResponse ファイル削除結果
   */
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<FileDeleteResponse> delete(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileDeleteRequest requestBody) {

    // レスポンスを返却
    // FileDeleteResponse res = new FileDeleteResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}
