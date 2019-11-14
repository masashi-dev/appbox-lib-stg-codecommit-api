package jp.co.fnj.storage.api.logic.externalfile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.SmartValidator;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.exception.StorageBadRequestException;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileGetRequest;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileGetResponse;
import jp.co.fnj.storage.api.service.externalfile.ExternalFileGetService;
import jp.co.fnj.storage.api.util.StorageApiUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ExternalFileGetLogic<REQUEST_BODY extends ExternalFileGetRequest, RESPONSE extends ExternalFileGetResponse> {

    @Autowired
    ExternalFileGetService externalFileGetService;

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
    public final ResponseEntity<RESPONSE> execute(HttpServletRequest request,
            HttpServletResponse response, REQUEST_BODY requestBody) throws StorageException {

        // バリデーション
        validate(requestBody);

        // メイン処理実行
        RESPONSE responseBody = innerExecute(request, response, requestBody);

        // 戻り値
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        // レスポンスヘッダーにIF_UNMODIFIED_SINCEを設定(ISO-8601形式)
        headerMap.add(HttpHeaders.IF_UNMODIFIED_SINCE,
                StorageApiUtil.toIso8601DateTime(getSystemDate()));

        return new ResponseEntity<RESPONSE>(responseBody, headerMap, HttpStatus.OK);
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
     * システム日時を取得します。
     * 
     * @return
     */
    protected DateTime getSystemDate() {
        return new DateTime(System.currentTimeMillis());
    }

    /**
     * バリデーションチェックを行う。
     * 
     * @param requestBody
     * @throws StorageException
     */
    protected void validate(REQUEST_BODY requestBody) throws StorageException {

        if (requestBody == null) {
            return;
        }

        BindingResult bindingResult = new DataBinder(requestBody).getBindingResult();
        validator.validate(requestBody, bindingResult, getValidationGroup());

        if (bindingResult.hasErrors()) {
            throw new StorageBadRequestException(Messages.E00007);
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
     * メイン処理
     * 
     * @param request
     * @param response
     * @param requestBody
     * @return
     * @throws StorageException
     */
    public RESPONSE innerExecute(HttpServletRequest request, HttpServletResponse response,
            REQUEST_BODY requestBody) throws StorageException {

        ExternalFileGetResponse externalFileGetResponse = new ExternalFileGetResponse();

        // サービスの呼び出し
        byte[] s3file = externalFileGetService.fileGet(requestBody.getFileId());
        externalFileGetResponse.setS3file(s3file);
        return (RESPONSE) externalFileGetResponse;
    }
}
