package jp.co.fnj.storage.api.logic.externalfile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import com.google.common.base.Strings;
import jp.co.fnj.storage.api.constant.FieldsPattern;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.exception.StorageBadRequestException;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileRegistRequest;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileRegistResponse;
import jp.co.fnj.storage.api.service.externalfile.ExternalFileRegistService;
import jp.co.fnj.storage.api.util.StorageApiUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ExternalFileRegistLogic<REQUEST_BODY extends ExternalFileRegistRequest, RESPONSE extends ExternalFileRegistResponse> {

    @Autowired
    ExternalFileRegistService externalFileRegistService;

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
        originalValidate(requestBody);

        // メイン処理実行
        innerExecute(request, response, requestBody);

        // 戻り値
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        // レスポンスヘッダーにIF_UNMODIFIED_SINCEを設定(ISO-8601形式)
        headerMap.add(HttpHeaders.IF_UNMODIFIED_SINCE,
                StorageApiUtil.toIso8601DateTime(getSystemDate()));
        return new ResponseEntity<RESPONSE>(headerMap, HttpStatus.OK);
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
     * バリデーションチェックを行う。(独自実装)
     * 
     * @param requestBody
     * @throws StorageException
     */
    protected void originalValidate(REQUEST_BODY requestBody) throws StorageException {
        boolean ngflg = false;
        Pattern filePattern = Pattern.compile(FieldsPattern.FILE_ID);
        Pattern developerPattern = Pattern.compile(FieldsPattern.DEVELOPER_ID);

        if (requestBody == null) {
            ngflg = true;
        }

        if (!ngflg) {
            // アップロードファイル
            if ((requestBody.getUploadFile() == null) || requestBody.getUploadFile().length == 0) {
                ngflg = true;
            }
        }

        if (!ngflg) {
            // ファイルID
            if (!Strings.isNullOrEmpty(requestBody.getFileId())) {
                // ファイルIDが指定してある場合
                // ファイルIDのフォーマットチェック
                Matcher matcher = filePattern.matcher(requestBody.getFileId());
                if (!matcher.matches()) {
                    ngflg = true;
                }
            } else {
                // ファイルIDが指定してない場合は「デベロッパID」「外部サービスファイルID」をチェック
                // デベロッパID
                if (!Strings.isNullOrEmpty(requestBody.getDeveloperId())) {
                    // デベロッパIDが指定してある場合
                    // デベロッパIDのフォーマットチェック
                    Matcher matcher = developerPattern.matcher(requestBody.getDeveloperId());
                    if (!matcher.matches()) {
                        ngflg = true;
                    }
                } else {
                    ngflg = true;
                }

                // 外部サービスファイルID
                if (!Strings.isNullOrEmpty(requestBody.getDeveloperId())) {
                    // 外部サービスファイルIDが指定してある場合
                    // 外部サービスファイルIDの桁数チェック
                    if (!(requestBody.getDeveloperId().length() == 14)) {
                        ngflg = true;
                    }
                } else {
                    ngflg = true;
                }

                // ファイル名
                if (!Strings.isNullOrEmpty(requestBody.getFileName())) {
                    ngflg = true;
                }
            }
        }

        if (ngflg) {
            throw new StorageException(Messages.E00007);
        }
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
    private void innerExecute(HttpServletRequest request, HttpServletResponse response,
            REQUEST_BODY requestBody) throws StorageException {

        // サービスの呼び出し
        externalFileRegistService.fileRegist(requestBody);
    }
}
