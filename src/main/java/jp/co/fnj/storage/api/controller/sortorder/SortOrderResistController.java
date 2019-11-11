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
import jp.co.fnj.storage.api.logic.sortorder.SortOrderResistLogic;
import jp.co.fnj.storage.api.model.sortorder.SortOrderResistRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderResistResponse;

/**
 * 表示順登録APIコントローラ.
 * 
 */
@RestController
@Validated
public class SortOrderResistController {

  @Autowired
  SortOrderResistLogic<SortOrderResistRequest, List<SortOrderResistResponse>> sortOrderResistLogic;

  @RequestMapping(method = RequestMethod.POST, path = StorageApiUrl.FILE_INSERT_DISPLAY_ORDER)
  public ResponseEntity<List<SortOrderResistResponse>> getList(HttpServletRequest request,
      HttpServletResponse response, @RequestBody SortOrderResistRequest requestBody) throws StorageException {

    return sortOrderResistLogic.execute(request, response, requestBody);
  }
}
