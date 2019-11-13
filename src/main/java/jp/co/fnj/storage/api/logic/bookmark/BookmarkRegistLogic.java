package jp.co.fnj.storage.api.logic.bookmark;

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
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistResponse;
import jp.co.fnj.storage.api.service.SequenceService;
import jp.co.fnj.storage.api.service.bookmark.BookmarkRegistService;

/**
 * お気に入り登録APIロジック.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class BookmarkRegistLogic<REQUEST_BODY extends BookmarkRegistRequest, RESPONSE extends BookmarkRegistResponse> {

  @Autowired
  private BookmarkRegistService<REQUEST_BODY, RESPONSE> bookmarkRegistService;

  @Autowired
  private SmartValidator validator;

  @Autowired
  private SequenceService sequenceService;
  
  /**
   * 事前処理
   * 
   * @param request
   * @param response
   * @param requestBody
   */
  private void preExecute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {};

  /**
   * 
   * @param request
   * @param response
   * @param requestBody
   * @throws StorageException
   */
  private void logicalCheck(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // セッション情報から実行権限をチェックする
    // TODO:未整備事項のため別途実装
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
      // お気に入りIDを発番
      String newBookmarkId = sequenceService.createBookmarkId();
      request.setAttribute("new_bookmark_id", newBookmarkId);

      // 各種サービスを順次実行
      bookmarkRegistService.execute(request, response, requestBody);

    } catch (Exception e) {
      throw new StorageRuntimeException(Messages.E00004, e);
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
      throw new StorageBadRequestException(Messages.E04001);
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
