package jp.co.fnj.storage.model.error;

import java.io.Serializable;

/**
 * バリデーションエラーのモデル
 * 
 * @author yamauchi
 *
 */
public class FieldErrorModel implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * フィールド
     */
    private String field;

    /**
     * フィールドエラーメッセージ
     */
    private String fieldErrorMessage;

    /**
     * コンストラクタ
     */
    public FieldErrorModel() {

    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldErrorMessage() {
        return fieldErrorMessage;
    }

    public void setFieldErrorMessage(String fieldErrorMessage) {
        this.fieldErrorMessage = fieldErrorMessage;
    }

}
