package jp.co.fnj.storage.api.controller.sortorder;

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
import jp.co.fnj.storage.api.logic.sortorder.SortOrderDeleteLogic;
import jp.co.fnj.storage.api.model.sortorder.SortOrderDeleteRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderDeleteResponse;

/**
 * 表示順削除APIコントローラ.
 * 
 */
@RestController
@Validated
public class SortOrderDeleteController {
	@Autowired
	SortOrderDeleteLogic<SortOrderDeleteRequest, SortOrderDeleteResponse> sortOrderDeleteLogic;
	
	@RequestMapping(method = RequestMethod.DELETE, path = StorageApiUrl.SORT_ORDER_DELETE)
	public ResponseEntity<SortOrderDeleteResponse> getList(HttpServletRequest request,
	    HttpServletResponse response, @RequestBody SortOrderDeleteRequest requestBody)
	    throws StorageException {

		return sortOrderDeleteLogic.execute(request, response, requestBody);
	}
}

