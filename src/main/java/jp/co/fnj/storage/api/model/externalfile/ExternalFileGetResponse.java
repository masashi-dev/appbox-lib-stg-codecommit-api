package jp.co.fnj.storage.api.model.externalfile;

/**
 * 外部ファイル登録のモデル
 * 
 * @author yamauchi
 *
 */
public class ExternalFileGetResponse {

  /**
   * コンストラクタ
   */
  public ExternalFileGetResponse() {
    // NOP
  }

  /**
   * s3ファイル
   */
  private byte[] s3file;

  public byte[] getS3file() {
    return s3file;
  }

  public void setS3file(byte[] s3file) {
    this.s3file = s3file;
  }
}
