package jp.co.fnj.storage.api.controller.bookmark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.constant.StorageApiUrl;
import jp.co.fnj.storage.api.logic.bookmark.BookmarkGetLogic;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteResponse;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetResponse;

/**
 * お気に入り取得コントローラー.
 *
 **/
@RestController
@Validated
public class BookmarkGetController {
  @Autowired
  BookmarkGetLogic<BookmarkGetRequest, BookmarkGetResponse> bookmarkGetLogic;
  
/**
 * お気に入り取得
 * @param request
 * @param response
 * @param requestBody
 * @return
 */
  @RequestMapping(value = StorageApiUrl.BOOKMARK_GET, method = RequestMethod.GET) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<BookmarkGetResponse> getBookmark(HttpServletRequest request,
      HttpServletResponse response, @RequestBody BookmarkGetRequest requestBody) {
    return bookmarkGetLogic.execute(request, response, requestBody);
  }
}
