package jp.co.fnj.storage.api.controller.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.logic.file.FileSearchLogic;
import jp.co.fnj.storage.api.model.file.FileSearchRequest;
import jp.co.fnj.storage.api.model.file.FileSearchResponse;

/**
 * ファイル検索APIコントローラ.
 *
 */
@RestController
@Validated
public class FileSearchController {

  @Autowired
  FileSearchLogic<FileSearchRequest, List<FileSearchResponse>> fileSearchLogic;

  @RequestMapping(method = RequestMethod.GET, value = "/filesearch2") // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<List<FileSearchResponse>> search(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileSearchRequest requestBody)
      throws StorageException {

    // requestBody.setFolder_id(folder_id);
    return fileSearchLogic.execute(request, response, requestBody);
  }

}
