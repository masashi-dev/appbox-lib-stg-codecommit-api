package jp.co.fnj.storage.api.logic.sample;

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
import jp.co.fnj.storage.api.model.sample.SampleRequest;
import jp.co.fnj.storage.api.model.sample.SampleResponse;
import jp.co.fnj.storage.api.service.sample.SampleService;

/**
 * ファイル一覧取得APIロジック.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
// TODO <REQUEST_BODY extends SampleResponse, RESPONSE extends SampleResponse>
// の部分はやめるかも
public class SampleLogic<REQUEST_BODY extends SampleRequest, RESPONSE extends SampleResponse> {

  @Autowired
  private SampleService<REQUEST_BODY, RESPONSE> sampleService;

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
  // TODO なくすかも
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
  // TODO なくすかも
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
  // TODO ここを実装
  private RESPONSE innerExecute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // 各種サービスを順次実行
    RESPONSE res = (RESPONSE) sampleService.execute(request, response, requestBody);
    return res;
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
      throw new StorageBadRequestException(Messages.E05001);
    }

  }



}
