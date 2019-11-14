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
import jp.co.fnj.storage.api.logic.sortorder.SortOrderLogicalNameSortLogic;
import jp.co.fnj.storage.api.model.sortorder.SortOrderLogicalNameSortRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderLogicalNameSortResponse;

/**
 * 0~9並び替えAPIコントローラ.
 * 
 */
@RestController
@Validated
public class SortOrderLogicalNameSortController {

  @Autowired
  SortOrderLogicalNameSortLogic<SortOrderLogicalNameSortRequest, SortOrderLogicalNameSortResponse> SortOrderLogicalNameSortLogic;

  @RequestMapping(method = RequestMethod.POST, path = StorageApiUrl.SORT_ORDER_LOGICAL_NAME_SORT)
  public ResponseEntity<SortOrderLogicalNameSortResponse> getList(HttpServletRequest request,
      HttpServletResponse response, @RequestBody SortOrderLogicalNameSortRequest requestBody) {

    return SortOrderLogicalNameSortLogic.execute(request, response, requestBody);
  }
}
