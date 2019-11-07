package jp.co.fnj.storage.api.model.externalfile;

import java.io.Serializable;
import java.util.List;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileDeleteRequest {

    /**
     * ファイルデータ
     */
    private String fileData;

    /**
     * コンストラクタ
     */
    public ExternalFileDeleteRequest() {
        // NOP
    }

    public String fileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }
}
