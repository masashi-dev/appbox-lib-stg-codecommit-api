package jp.co.fnj.storage.api.model.error;

import java.io.Serializable;
import java.util.List;

/**
 * エラーレスポンスのモデル
 * 
 * @author yamauchi
 *
 */
public class AppboxPlatformApiErrorResponse implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * エラーコード
     */
    private String errorCode;

    /**
     * エラーメッセージ
     */
    private String errorMessage;

    /**
     * フィールドエラーリスト
     */
    private List<FieldErrorModel> fieldErrorList;


    /**
     * コンストラクタ
     */
    public AppboxPlatformApiErrorResponse() {
        // NOP
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<FieldErrorModel> getFieldErrorList() {
        return fieldErrorList;
    }

    public void setFieldErrorList(List<FieldErrorModel> fieldErrorList) {
        this.fieldErrorList = fieldErrorList;
    }

}
