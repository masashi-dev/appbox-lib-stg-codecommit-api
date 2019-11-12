package jp.co.fnj.storage.api.logic.sortorder;

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
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateResponse;
import jp.co.fnj.storage.api.service.sortorder.SortOrderUpdateService;

/**
 * 表示順更新APIロジック.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderUpdateLogic<REQUEST_BODY extends SortOrderUpdateRequest, RESPONSE extends SortOrderUpdateResponse> {

  @Autowired
  private SortOrderUpdateService<REQUEST_BODY, RESPONSE> sortOrderUpdateService;

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
      REQUEST_BODY requestBody) {

    // リクエスト項目「ファイルID」「フォルダID」のどちらかのみが設定されていることをチェック
    if ((requestBody.getFile_id() == null && requestBody.getFolder_id() == null)
        || (requestBody.getFile_id() != null && requestBody.getFolder_id() != null)) {
      throw new StorageBadRequestException(Messages.E02001);
    }

  }

  /**
   * メイン処理.
   * 
   * @param request
   * @param response
   * @param requestBody
   * @return
   * @throws StorageException
   */
  private void innerExecute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    try {
      // 各種サービスを順次実行
      sortOrderUpdateService.execute(request, response, requestBody);

    } catch (Exception ex) {
      throw new StorageBadRequestException(Messages.E02025);
    }

    return;
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
      HttpServletResponse response, REQUEST_BODY requestBody) throws StorageException {

    // 事前実行
    preExecute(request, response, requestBody);

    // バリデーション
    validate(requestBody);

    // ロジカルチェック
    logicalCheck(request, response, requestBody);

    // メイン処理実行
    innerExecute(request, response, requestBody);

    MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();

    return new ResponseEntity<RESPONSE>(null, headerMap, HttpStatus.OK);
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
    validator.validate(requestBody, bindingResult, getValidationGroup());

    if (bindingResult.hasErrors()) {
      throw new StorageBadRequestException(Messages.E05007);
    }

  }

  /**
   * バリデーショングループを取得します。
   * 
   * @return
   */
  private Class<?> getValidationGroup() {
    return null;
  }



}