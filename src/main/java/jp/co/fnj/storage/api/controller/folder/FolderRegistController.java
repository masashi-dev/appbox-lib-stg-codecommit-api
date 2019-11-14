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
import jp.co.fnj.storage.api.model.folder.FolderRegistRequest;
import jp.co.fnj.storage.api.model.folder.FolderRegistResponse;

/**
 * フォルダ作成APIコントローラ.
 *
 */
@RestController
@Validated
public class FolderRegistController {

  /**
   * フォルダ作成.
   *
   * 指定されたフォルダの下に新しいフォルダを作成する.
   *
   * @param folder_name フォルダ名
   * @param private_flg 公開フラグ
   * @param explanatory_text 説明
   * @param parent_folder_id 親フォルダID
   * @return FolderRegistResponse
   */
  @RequestMapping(method = RequestMethod.POST, path = "/folderregist") // TODO:エンドポイントは確定後書き換えること
  public ResponseEntity<List<FolderRegistResponse>> regist(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FolderRegistRequest requestBody) {

    // レスポンスを返却
    // FolderRegistResponse res = new FolderRegistResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}
