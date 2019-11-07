package jp.co.fnj.storage.model.s3uploadfile;

import java.io.Serializable;
import java.util.List;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class S3UploadFileInfoRegistResponse {

    /**
     * ファイルデータ
     */
    private String fileId;

    /**
     * コンストラクタ
     */
    public S3UploadFileInfoRegistResponse() {
        // NOP
    }

    public String fileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
