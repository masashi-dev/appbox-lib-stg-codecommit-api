package jp.co.fnj.storage.api.model.externalfile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import jp.co.fnj.storage.api.constant.FieldsPattern;

/**
 * 外部ファイル取得のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileGetRequest {

    /**
     * コンストラクタ
     */
    public ExternalFileGetRequest() {
        // NOP
    }

    /**
     * ファイルID
     */
    @NotNull
    @Size(min = 14, max = 14)
    @Pattern(regexp = FieldsPattern.FILE_ID)
    private String fileId;

    /**
     * アプリ区分
     */
    @Pattern(regexp = FieldsPattern.APL_KBN_APPBOX_APPBOXEXCEPT_KANRI_INFO)
    private String apiKbn;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getApiKbn() {
        return apiKbn;
    }

    public void setApiKbn(String apiKbn) {
        this.apiKbn = apiKbn;
    }
}
