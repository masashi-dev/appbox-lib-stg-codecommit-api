package jp.co.fnj.storage.api.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AwsS3Util {

  @Value("${s3.accessKey}")
  private String accessKey;

  @Value("${s3.secretKey}")
  private String secretAccesskey;

  @Value("${s3.bucketName}")
  private String bucketName;

  /**
   * AmazonS3のファイルを削除
   * 
   * @param ファイルパス
   */
  public void fileDelete(String filePath) throws Exception {

    // AmazonS3クライアントを生成
    AmazonS3 s3Client = this.getClient();

    // AmazonS3のファイルを削除
    s3Client.deleteObject(new DeleteObjectRequest(bucketName, filePath));
  }


  /**
   * AmazonS3のファイルを取得
   * 
   * @param ファイルパス
   */
  public byte[] fileGet(String filePath) throws Exception {

    // AmazonS3クライアントを生成
    AmazonS3 s3Client = this.getClient();

    // AmazonS3のファイルを取得
    GetObjectRequest request = new GetObjectRequest(bucketName, filePath);
    S3Object object = s3Client.getObject(request);

    // ストリームを取得
    S3ObjectInputStream input = object.getObjectContent();
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    int len = 0;
    byte buff[] = new byte[1024];
    while ((len = input.read(buff)) != -1) {
      bout.write(buff, 0, len);
    }
    return bout.toByteArray();
  }

  /**
   * AmazonS3にファイルを登録
   * 
   * @param オブジェクトキー
   * @param ファイルデータ
   */
  public void fileRegist(String objKey, byte[] fileData) throws Exception {

    // AmazonS3クライアントを生成
    AmazonS3 s3Client = this.getClient();

    // AmazonS3にファイルを登録
    // メタ情報の生成
    ObjectMetadata metaData = new ObjectMetadata();
    metaData.setContentLength(fileData.length);

    // リクエストの生成
    ByteArrayInputStream inputStream = new ByteArrayInputStream(fileData);
    PutObjectRequest request = new PutObjectRequest(bucketName, objKey, inputStream, metaData);

    // アップロード
    s3Client.putObject(request);
  }

  /**
   * S3上ファイルのContentTypeチェック
   * 
   * @param filePath
   * @return ContentType
   */
  public String getContentType(String filePath) throws Exception {
    String contenType = null;

    AmazonS3 s3Client = this.getClient();
    S3Object object = s3Client.getObject(bucketName, filePath);

    if (object != null && object.getObjectMetadata() != null
        && object.getObjectMetadata().getContentType() != null) {
      contenType = object.getObjectMetadata().getContentType();
    }
    return contenType;
  }


  /**
   * AmazonS3クライアントを生成
   * 
   * @return AmazonS3クライアント
   */
  private AmazonS3 getClient() {

    // AWSアクセスキー、AWSシークレットアクセスキーを利用して認証情報をしてする
    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretAccesskey);

    // クライアントを生成
    AmazonS3 client = AmazonS3ClientBuilder.standard()
        // 認証情報を設定
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        // リージョンを US_EAST_2(オハイオ) に設定
        .withRegion(Regions.US_EAST_2).build();

    return client;
  }
}
