package jp.co.fnj.storage.api.controller.folder;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.model.folder.FolderRegistResponse;
import jp.co.fnj.storage.api.model.folder.FolderUpdateRequest;

/**
 * フォルダ更新APIコントローラ.
 *
 */
@RestController
@Validated
public class FolderUpdateController {

  /**
   * フォルダ更新.
   *
   * 指定されたフォルダの情報を更新する.
   *
   * @param folder_id フォルダID
   * @param folder_name フォルダ名
   * @param private_flg 公開フラグ
   * @param explanatory_text 説明
   * @return FolderUpdateResponse
   */
  @RequestMapping(method = RequestMethod.PUT, path = "/folderupdate") // TODO:エンドポイントは確定後書き換えること
  public ResponseEntity<List<FolderRegistResponse>> folderUpdate(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FolderUpdateRequest requestBody) {

    // レスポンスを返却
    // FolderUpdateResponse res = new FolderUpdateResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}
