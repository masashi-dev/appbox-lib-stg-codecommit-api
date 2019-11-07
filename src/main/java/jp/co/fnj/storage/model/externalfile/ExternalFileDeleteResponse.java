package jp.co.fnj.storage.model.externalfile;

import java.io.Serializable;
import java.util.List;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileDeleteResponse {

    /**
     * ファイルデータ
     */
    private String fileId;

    /**
     * コンストラクタ
     */
    public ExternalFileDeleteResponse() {
        // NOP
    }

    public String fileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
