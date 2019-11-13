package jp.co.fnj.storage.api.logic.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.SmartValidator;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.exception.StorageBadRequestException;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.file.FileSearchRequest;
import jp.co.fnj.storage.api.model.file.FileSearchResponse;
import jp.co.fnj.storage.api.service.file.FileSearchService;

/**
 * ファイル検索APIロジック.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileSearchLogic<REQUEST_BODY extends FileSearchRequest, RESPONSE extends List<FileSearchResponse>> {

  @Autowired
  private FileSearchService<REQUEST_BODY, RESPONSE> fileSearchService;

  @Autowired
  private SmartValidator validator;

  /**
   * 事前処理.
   * 
   * @param request
   * @param response
   * @param requestBody
   * @throws StorageException
   */
  private void preExecute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {};

  /**
   * ロジカルチェック.
   * 
   * @param request
   * @param response
   * @param requestBody
   * @throws StorageException
   */
  private void logicalCheck(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {}

  /**
   * メイン処理.
   * 
   * @param request
   * @param response
   * @param requestBody
   * @return
   * @throws StorageException
   */
  private RESPONSE innerExecute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    try {
      // 各種サービスを順次実行
      RESPONSE res = (RESPONSE) fileSearchService.execute(request, response, requestBody);
      return res;
    } catch (Exception e) {
      throw new StorageRuntimeException(Messages.E02020, e);
    }
  }

  /**
   * 認証情報を取得します。
   * 
   * @return
   * @throws StorageException
   */
  // protected AppboxPlatformUser getAuthenticationPrincipal() throws AppboxPlatformException {
  // return AuthenticationUtil.getAuthenticationPrincipal();
  // }

  /**
   * 処理実行
   * 
   * @param request
   * @param response
   * @param requestBody
   * @return
   * @throws StorageException
   */
  public final ResponseEntity<RESPONSE> execute(HttpServletRequest request,
      HttpServletResponse response, REQUEST_BODY requestBody) {

    // 事前実行
    preExecute(request, response, requestBody);

    // バリデーション
    validate(requestBody);

    // ロジカルチェック
    logicalCheck(request, response, requestBody);

    // メイン処理実行
    RESPONSE responseBody = innerExecute(request, response, requestBody);

    MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();

    return new ResponseEntity<RESPONSE>(responseBody, headerMap, HttpStatus.OK);
  }

  /**
   * バリデーションチェックを行う。
   * 
   * @param requestBody
   * @throws StorageException
   */
  private void validate(REQUEST_BODY requestBody) {

    if (requestBody == null) {
      return;
    }

    BindingResult bindingResult = new DataBinder(requestBody).getBindingResult();
    validator.validate(requestBody, bindingResult);

    if (bindingResult.hasErrors()) {
      throw new StorageBadRequestException(Messages.E00007);
    }

  }

}
