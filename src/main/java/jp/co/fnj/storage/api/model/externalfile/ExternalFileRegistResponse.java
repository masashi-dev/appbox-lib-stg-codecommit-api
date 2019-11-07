package jp.co.fnj.storage.api.model.externalfile;

import java.io.Serializable;
import java.util.List;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileRegistResponse {

    /**
     * ファイルID
     */
    private String fileId;

    /**
     * コンストラクタ
     */
    public ExternalFileRegistResponse() {
        // NOP
    }

    public String fileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
