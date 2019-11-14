package jp.co.fnj.storage.api.service.externalfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TExternalServiceObjectMapper;
import jp.co.fnj.storage.api.entity.model.generat.TExternalServiceObject;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.util.AwsS3Util;



@Service
public class ExternalFileDeleteService {

    @Autowired
    private TExternalServiceObjectMapper tExternalServiceObjectMapper;

    @Autowired
    private AwsS3Util awsS3Util;

    /**
     * Amazon S3のファイルを削除します
     * 
     * @param request
     * @throws AppboxStorageException
     */
    public void fileDelete(String fileId) throws StorageException {

        try {

            // 外部サービス登録オブジェクトテーブルの検索
            TExternalServiceObject entity = tExternalServiceObjectMapper.selectByPrimaryKey(fileId);
            if (entity == null) {
                throw new StorageException(Messages.E00002);
            }

            // Amazon_S3のファイルを削除
            awsS3Util.fileDelete(entity.getFilePath());

            // 外部サービス登録オブジェクトテーブルの削除
            tExternalServiceObjectMapper.deleteByPrimaryKey(fileId);

        } catch (Exception e) {
            throw new StorageException(Messages.E00004);
        }
    }
}
