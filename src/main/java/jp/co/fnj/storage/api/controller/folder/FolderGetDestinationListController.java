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
import jp.co.fnj.storage.api.model.folder.FolderGetDestinationListRequest;
import jp.co.fnj.storage.api.model.folder.FolderGetDestinationListResponse;

/**
 * 移動先フォルダリスト取得APIコントローラ.
 *
 */
@RestController
@Validated
public class FolderGetDestinationListController {

  /**
   * 移動先フォルダリスト取得.
   *
   * 指定されたフォルダのマンションIDに属するフォルダのリストを返却する。
   *
   * @param folder_id フォルダID
   * @return FolderGetDestinationListResponse ファイル検索結果
   */
  @RequestMapping(method = RequestMethod.GET, path = "foldergetdestlist") // TODO:エンドポイントは確定後書き換えること
  public ResponseEntity<List<FolderGetDestinationListResponse>> getDesinationList(
      HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute FolderGetDestinationListRequest requestBody) {

    // レスポンスを返却
    // FolderGetDestinationListResponse res = new FolderGetDestinationListResponse();
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}
