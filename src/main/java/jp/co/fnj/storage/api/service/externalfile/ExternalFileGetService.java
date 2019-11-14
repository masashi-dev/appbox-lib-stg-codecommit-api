package jp.co.fnj.storage.api.service.externalfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TExternalServiceObjectMapper;
import jp.co.fnj.storage.api.entity.model.generat.TExternalServiceObject;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.util.AwsS3Util;

@Service
public class ExternalFileGetService {

    @Autowired
    private TExternalServiceObjectMapper tExternalServiceObjectMapper;

    @Autowired
    private AwsS3Util awsS3Util;

    /**
     * Amazon S3のファイルを取得します
     * 
     * @param ファイルID
     * @throws StorageException
     */
    public byte[] fileGet(String fileId) throws StorageException {

        try {

            // 外部サービス登録オブジェクトテーブルの検索
            TExternalServiceObject entity = tExternalServiceObjectMapper.selectByPrimaryKey(fileId);
            if (entity == null) {
                throw new StorageException(Messages.E00002);
            }

            // Amazon_S3のファイルを取得
            byte[] s3file = awsS3Util.fileGet(entity.getFilePath());
            return s3file;

        } catch (Exception e) {
            throw new StorageException(Messages.E00004);
        }
    }
}

