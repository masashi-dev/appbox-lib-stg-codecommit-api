package jp.co.fnj.storage.api.controller.foldercheck;

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
import jp.co.fnj.storage.api.logic.filecheck.FileNameCheckLogic;
import jp.co.fnj.storage.api.model.filecheck.FileNameCheckRequest;
import jp.co.fnj.storage.api.model.filecheck.FileNameCheckResponse;

/**
 * 論理フォルダ名重複チェックAPIコントローラー.
 *
 **/
@RestController
@Validated
public class FolderNameCheckController {

  @Autowired // TODO 後で変える
  private FileNameCheckLogic<FileNameCheckRequest, FileNameCheckResponse> fileNameCheckLogic;

  /**
   * 
   * ファイル論理名重複チェックAPI.
   * 
   * @return
   */
  @RequestMapping(value = StorageApiUrl.FOLDERNAME_CHECK, method = RequestMethod.GET)
  public ResponseEntity<FileNameCheckResponse> fileNameCheck(HttpServletRequest request,
      HttpServletResponse response, @RequestBody FileNameCheckRequest requestBody) {

    // レスポンスを返却
    return fileNameCheckLogic.execute(request, response, requestBody);
  }

}
