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
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.logic.bookmark.BookmarkRegistLogic;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistResponse;


/**
 * お気に入り登録コントローラー
 *
 */
@RestController
@Validated
public class BookmarkRegisatController {
	@Autowired
	BookmarkRegistLogic<BookmarkRegistRequest, BookmarkRegistResponse> bookmarkRegistLogic;

	@RequestMapping(method = RequestMethod.POST, path = StorageApiUrl.BOOKMARK_REGIST)
	public ResponseEntity<BookmarkRegistResponse> register(HttpServletRequest request,
	    HttpServletResponse response, @RequestBody BookmarkRegistRequest requestBody) {

		return bookmarkRegistLogic.execute(request, response, requestBody);
	}
}
