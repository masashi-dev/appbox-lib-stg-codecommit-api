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
import jp.co.fnj.storage.api.logic.file.FileUpdateDisplayOrderLogic;
import jp.co.fnj.storage.api.model.file.FileUpdateDisplayOrderRequest;
import jp.co.fnj.storage.api.model.file.FileUpdateDisplayOrderResponse;

/**
 * 表示順更新APIコントローラ.
 * 
 */
@RestController
@Validated
public class FileUpdateDisplayOrderController {

  @Autowired
  FileUpdateDisplayOrderLogic<FileUpdateDisplayOrderRequest, List<FileUpdateDisplayOrderResponse>> fileUpdateDisplayOrderLogic;

  @RequestMapping(method = RequestMethod.PUT, path = StorageApiUrl.FILE_UPDATE_DISPLAY_ORDER)
  public ResponseEntity<List<FileUpdateDisplayOrderResponse>> getList(HttpServletRequest request,
      HttpServletResponse response, @RequestBody FileUpdateDisplayOrderRequest requestBody) throws StorageException {

    return fileUpdateDisplayOrderLogic.execute(request, response, requestBody);
  }
}
