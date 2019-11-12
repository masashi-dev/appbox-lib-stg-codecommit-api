package jp.co.fnj.storage.api.controller.bookmark;

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

import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteResponce;

/********************************************************************
 *
 * STORAGE-FNC-024 お気に入り削除コントローラー
 *
 * @author
 * @version 1.0
 *
 *******************************************************************/
@RestController
public class BookmarkDeleteController {

	/**
	 * お気に入り削除
	 *
	 * お気に入り情報を削除する。 物理削除とする。
	 *
	 * @param bookmark_id お気に入りID
	 * @return BookmarkDeleteResponce ユーザー情報
	 */
	@RequestMapping(value = "/bookmark", method = RequestMethod.DELETE)
	public ResponseEntity<BookmarkDeleteResponce> bookmarkDelete(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute @Validated BookmarkDeleteRequest requestBody){

		// レスポンスを返却
		// BookmarkDeleteResponce res = new BookmarkDeleteResponce();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}

}
