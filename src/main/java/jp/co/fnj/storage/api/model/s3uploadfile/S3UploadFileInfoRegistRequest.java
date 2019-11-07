package jp.co.fnj.storage.api.model.s3uploadfile;

import java.io.Serializable;
import java.util.List;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class S3UploadFileInfoRegistRequest {

    /**
     * ファイルデータ
     */
    private String fileData;

    /**
     * コンストラクタ
     */
    public S3UploadFileInfoRegistRequest() {
        // NOP
    }

    public String fileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }
}
