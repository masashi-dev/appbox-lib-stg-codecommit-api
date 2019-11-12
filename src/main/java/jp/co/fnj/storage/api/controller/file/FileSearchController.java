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
import jp.co.fnj.storage.api.model.file.FileSearchRequest;
import jp.co.fnj.storage.api.model.file.FileSearchResponse;

/**
 * ファイル検索コントローラー.
 *
 **/
@RestController
@Validated
public class FileSearchController {

  /**
   * お気に入り削除
   *
   * お気に入り情報を削除する。 物理削除とする。
   *
   * @param bookmark_id お気に入りID
   * @return BookmarkDeleteResponce ユーザー情報
   */
  @RequestMapping(value = "/filesearch", method = RequestMethod.GET) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<FileSearchResponse> search(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileSearchRequest requestBody) {

    // レスポンスを返却
    FileSearchResponse res = new FileSearchResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(res, headers, HttpStatus.OK);
  }

}
