package jp.co.fnj.storage.api.controller.bookmark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.constant.StorageApiUrl;
import jp.co.fnj.storage.api.logic.bookmark.BookmarkDeleteLogic;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteResponse;

/**
 * お気に入り削除コントローラー.
 *
 **/
@RestController
@Validated
public class BookmarkDeleteController {
  
  @Autowired
  BookmarkDeleteLogic<BookmarkDeleteRequest, BookmarkDeleteResponse> bookmarkDeleteLogic;

  /**
   * お気に入り削除
   *
   * お気に入り情報を削除する。 物理削除とする。
   *
   * @param bookmark_id お気に入りID
   * @return BookmarkDeleteResponce ユーザー情報
   */
  @RequestMapping(value = StorageApiUrl.BOOKMARK_DELETE, method = RequestMethod.DELETE) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<BookmarkDeleteResponse> bookmarkDelete(HttpServletRequest request,
      HttpServletResponse response, @RequestBody BookmarkDeleteRequest requestBody) {
    return bookmarkDeleteLogic.execute(request, response, requestBody);
  }

}
