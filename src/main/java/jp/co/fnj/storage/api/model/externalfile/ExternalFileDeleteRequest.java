package jp.co.fnj.storage.api.model.externalfile;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.fnj.storage.api.constant.FieldsPattern;

/**
 * 外部ファイル削除のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileDeleteRequest {

    /**
     * コンストラクタ
     */
    public ExternalFileDeleteRequest() {
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
    @Pattern(regexp = FieldsPattern.APL_KBN_INFO)
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
