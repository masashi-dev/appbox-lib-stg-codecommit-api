package jp.co.fnj.storage.api.model.externalfile;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileRegistRequest {

    /**
     * コンストラクタ
     */
    public ExternalFileRegistRequest() {
        // NOP
    }

    /**
     * ファイルID
     */
    private String fileId;

    /**
     * アップロードファイル
     */
    private byte[] uploadFile;

    /**
     * デベロッパID
     */
    private String developerId;

    /**
     * 外部サービスファイルID
     */
    private String exceptId;

    /**
     * ファイル名
     */
    private String fileName;

    /**
     * アプリ区分
     */
    private String apiKbn;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public byte[] getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(byte[] uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getExceptId() {
        return exceptId;
    }

    public void setExceptId(String exceptId) {
        this.exceptId = exceptId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getApiKbn() {
        return apiKbn;
    }

    public void setApiKbn(String apiKbn) {
        this.apiKbn = apiKbn;
    }
}
