package jp.co.fnj.storage.api.controller.sortorder;

import java.util.List;
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
  SortOrderUpdateLogic<SortOrderUpdateRequest, List<SortOrderUpdateResponse>> sortOrderUpdateLogic;

  @RequestMapping(method = RequestMethod.PUT, path = StorageApiUrl.SORT_ORDER_UPDATE)
  public ResponseEntity<List<SortOrderUpdateResponse>> getList(HttpServletRequest request,
      HttpServletResponse response, @RequestBody SortOrderUpdateRequest requestBody)
      throws StorageException {

    return sortOrderUpdateLogic.execute(request, response, requestBody);
  }
}
