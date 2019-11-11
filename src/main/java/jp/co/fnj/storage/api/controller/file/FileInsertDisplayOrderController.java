package jp.co.fnj.storage.api.controller.file;

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
import jp.co.fnj.storage.api.logic.file.FileInsertDisplayOrderLogic;
import jp.co.fnj.storage.api.model.file.FileInsertDisplayOrderRequest;
import jp.co.fnj.storage.api.model.file.FileInsertDisplayOrderResponse;

/**
 * 表示順登録APIコントローラ.
 * 
 */
@RestController
@Validated
public class FileInsertDisplayOrderController {

  @Autowired
  FileInsertDisplayOrderLogic<FileInsertDisplayOrderRequest, List<FileInsertDisplayOrderResponse>> fileUpdateDisplayOrderLogic;

  @RequestMapping(method = RequestMethod.POST, path = StorageApiUrl.FILE_INSERT_DISPLAY_ORDER)
  public ResponseEntity<List<FileInsertDisplayOrderResponse>> getList(HttpServletRequest request,
      HttpServletResponse response, @RequestBody FileInsertDisplayOrderRequest requestBody) throws StorageException {

    return fileUpdateDisplayOrderLogic.execute(request, response, requestBody);
  }
}
