package jp.co.fnj.storage.api.logic;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.SmartValidator;

import jp.co.fnj.storage.constant.Messages;
import jp.co.fnj.storage.exception.StorageBadRequestException;
import jp.co.fnj.storage.exception.StorageException;
import jp.co.fnj.storage.model.externalfile.ExternalFileDeleteRequest;
import jp.co.fnj.storage.model.externalfile.ExternalFileDeleteResponse;
import jp.co.fnj.storage.service.ExternalFileDeleteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ExternalFileDeleteLogic <REQUEST_BODY extends ExternalFileDeleteRequest, RESPONSE extends ExternalFileDeleteResponse> {
	
	@Autowired
	ExternalFileDeleteService externalFileDeleteService;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    private SmartValidator validator;

    /**
     * 処理実行
     * 
     * @param request
     * @param response
     * @param requestBody
     * @return
     * @throws StorageException
     */
    public final ResponseEntity<RESPONSE> execute(HttpServletRequest request, HttpServletResponse response, REQUEST_BODY requestBody)
            throws StorageException {

        // 事前実行
        preExecute(request, response, requestBody);

        // バリデーション
        validate(requestBody);

        // ロジカルチェックなし
        // logicalCheck(request, response, requestBody);

        // メイン処理実行
        RESPONSE responseBody = innerExecute(request, response, requestBody);

        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();

        return new ResponseEntity<RESPONSE>(responseBody, headerMap, HttpStatus.OK);
    }
    
    /**
     * 認証情報を取得します。
     * 
     * @return
     * @throws AppboxPlatformException
     */
//    protected AppboxPlatformUser getAuthenticationPrincipal() throws AppboxPlatformException {
//        return AuthenticationUtil.getAuthenticationPrincipal();
//    }

    /**
     * システム日時を取得します。
     * 
     * @return
     */
    protected LocalDateTime getSystemDate() {
        return LocalDateTime.now();
    }

    /**
     * バリデーションチェックを行う。
     * 
     * @param requestBody
     * @throws AppboxPlatformException
     */
    protected void validate(REQUEST_BODY requestBody) throws StorageException {

        if (requestBody == null) {
            return;
        }

        BindingResult bindingResult = new DataBinder(requestBody).getBindingResult();
        validator.validate(requestBody, bindingResult, getValidationGroup());

        if (bindingResult.hasErrors()) {
            throw new StorageBadRequestException(Messages.E05001);
        }

    }

    /**
     * バリデーショングループを取得します。 各機能で任意でオーバーライドしてください。
     * 
     * @return
     */
    protected Class<?> getValidationGroup() throws StorageException {
        return null;
    }

    /**
     * レスポンスヘッダーにIF_UNMODIFIED_SINCEを含めるか？
     * 
     * @return
     */
    protected abstract Boolean isAddResponseHeaderIfUnmodifiedSince();

    /**
     * 事前処理
     * 
     * @param request
     * @param response
     * @param requestBody
     * @throws AppboxPlatformException
     */
    protected abstract void preExecute(HttpServletRequest request, HttpServletResponse response, REQUEST_BODY requestBody)
            throws StorageException;

    /**
     * ロジカルチェック
     * 
     * @param request
     * @param response
     * @param requestBody
     * @throws AppboxPlatformException
     */
    protected abstract void logicalCheck(HttpServletRequest request, HttpServletResponse response, REQUEST_BODY requestBody)
            throws StorageException;
    
    /**
     * メイン処理
     * 
     * @param request
     * @param response
     * @param requestBody
     * @return
     * @throws AppboxPlatformException
     */
    protected abstract RESPONSE innerExecute(HttpServletRequest request, HttpServletResponse response, REQUEST_BODY requestBody)
            throws StorageException;
}
