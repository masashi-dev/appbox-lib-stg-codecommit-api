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
import jp.co.fnj.storage.api.logic.sortorder.SortOrderUpdateLogic;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateResponse;

/**
 * 表示順更新APIコントローラ.
 * 
 */
@RestController
@Validated
public class SortOrderUpdateController {

  @Autowired
  SortOrderUpdateLogic<SortOrderUpdateRequest, SortOrderUpdateResponse> sortOrderUpdateLogic;

  @RequestMapping(method = RequestMethod.PUT, path = StorageApiUrl.SORT_ORDER_UPDATE)
  public ResponseEntity<SortOrderUpdateResponse> getList(HttpServletRequest request,
      HttpServletResponse response, @RequestBody SortOrderUpdateRequest requestBody) {

    return sortOrderUpdateLogic.execute(request, response, requestBody);
  }
}
