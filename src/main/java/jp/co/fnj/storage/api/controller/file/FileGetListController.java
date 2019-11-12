package jp.co.fnj.storage.api.controller.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.constant.StorageApiUrl;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.logic.file.FileGetListLogic;
import jp.co.fnj.storage.api.model.file.FileGetListRequest;
import jp.co.fnj.storage.api.model.file.FileGetListResponse;

/**
 * ファイル一覧取得APIコントローラ.
 * 
 */
@RestController
@Validated
public class FileGetListController {

  @Autowired
  FileGetListLogic<FileGetListRequest, List<FileGetListResponse>> fileGetListLogic;

  @RequestMapping(method = RequestMethod.GET, path = StorageApiUrl.FILE_GET_LIST)
  public ResponseEntity<List<FileGetListResponse>> getList(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileGetListRequest requestBody,
      @PathVariable String folder_id) throws StorageException {

    requestBody.setFolder_id(folder_id);
    return fileGetListLogic.execute(request, response, requestBody);
  }
}
