package jp.co.fnj.storage.api.controller.file;

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
import jp.co.fnj.storage.api.model.file.FileUpdateRequest;
import jp.co.fnj.storage.api.model.file.FileUpdateResponse;

/**
 * ファイル名変更コントローラー.
 *
 **/
@RestController
@Validated
public class FileUpdateController {

  /**
   * ファイル名変更.
   *
   * ファイル名称の変更を行う。 ストレージサービス上表示される論理名称の変更とし、物理ファイル名称は変更しないものとする。
   *
   * @param file_id ファイルID
   * @param file_name 論理ファイル名
   * @param folder_id フォルダID
   * @return FileUpdateResponse ファイル検索結果
   */
  @RequestMapping(value = "/fileupdate", method = RequestMethod.POST) // TODO エンドポイントは確定後書き換えること
  public ResponseEntity<FileUpdateResponse> fileupdate(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute @Validated FileUpdateRequest requestBody) {

    // レスポンスを返却
    // FileUpdateResponse res = new FileUpdateResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}
