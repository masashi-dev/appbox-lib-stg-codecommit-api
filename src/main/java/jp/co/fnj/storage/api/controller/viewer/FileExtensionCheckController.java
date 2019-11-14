package jp.co.fnj.storage.api.controller.viewer;

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
import jp.co.fnj.storage.api.model.viewer.FileExtensionCheckRequest;
import jp.co.fnj.storage.api.model.viewer.FileExtensionCheckResponse;
import jp.co.fnj.storage.api.constant.StorageApiUrl;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.logic.viewer.FileExtensionCheckLogic;

/**
 * ファイル拡張子チェックコントローラー.
 *
 **/
@RestController
@Validated
public class FileExtensionCheckController {

  /**
   * ファイル拡張子チェック.
   *
   * ファイルの拡張子を確認し返却します。
   *
   * @param file_id ファイルID
   * @return FileExtensionCheckResponse ファイル検索結果
   */
  @Autowired
  FileExtensionCheckLogic<FileExtensionCheckRequest, FileExtensionCheckResponse> FileExtensionCheckLogic;

  @RequestMapping(method = RequestMethod.GET, path = StorageApiUrl.FILE_EXTENSION_CHECK) // TODO
                                                                                         // エンドポイントは確定後書き換えること
  public ResponseEntity<FileExtensionCheckResponse> extensionCheck(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileExtensionCheckRequest requestBody,
      @PathVariable String file_id) {

    // レスポンスを返却
    requestBody.setFile_id(file_id);
    return FileExtensionCheckLogic.execute(request, response, requestBody);
  }

}
