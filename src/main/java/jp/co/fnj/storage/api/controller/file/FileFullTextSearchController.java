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
import jp.co.fnj.storage.api.logic.file.FileFullTextSearchLogic;
import jp.co.fnj.storage.api.model.file.FileFullTextSearchRequest;
import jp.co.fnj.storage.api.model.file.FileFullTextSearchResponse;

/**
 * ファイル全文検索APIコントローラ.
 *
 */
@RestController
@Validated
public class FileFullTextSearchController {

  @Autowired
  FileFullTextSearchLogic<FileFullTextSearchRequest, List<FileFullTextSearchResponse>> fileFullTextSearchLogic;

  /**
   * ファイル全文検索.
   *
   * 指定した入力を元にファイル名、ファイルの全文検索を行う。
   *
   * @param folder_id フォルダID
   * @param search_word 検索ワード
   * @return FileFullTextSearchResponse ファイル検索結果
   */
  @RequestMapping(method = RequestMethod.GET, path = "/fulltextsearch") // TODO:エンドポイントは確定後書き換えること
  public ResponseEntity<List<FileFullTextSearchResponse>> fullTextSearch(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute FileFullTextSearchRequest requestBody) {

    return fileFullTextSearchLogic.execute(request, response, requestBody);
  }

}
