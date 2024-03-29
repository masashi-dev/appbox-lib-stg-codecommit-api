package jp.co.fnj.storage.model.externalfile;

import java.io.Serializable;
import java.util.List;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileGetRequest {

    /**
     * ファイルデータ
     */
    private String fileData;

    /**
     * コンストラクタ
     */
    public ExternalFileGetRequest() {
        // NOP
    }

    public String fileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }
}
