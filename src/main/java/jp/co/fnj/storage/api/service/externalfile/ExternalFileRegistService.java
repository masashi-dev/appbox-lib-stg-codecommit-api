package jp.co.fnj.storage.api.service.externalfile;

import java.time.LocalDateTime;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.constant.StorageConstant;
import jp.co.fnj.storage.api.entity.mapper.generat.TExternalServiceObjectMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TFolderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TExternalServiceObject;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileRegistRequest;
import jp.co.fnj.storage.api.util.AwsS3Util;

@Service
public class ExternalFileRegistService {

    @Autowired
    private TExternalServiceObjectMapper tExternalServiceObjectMapper;

    @Autowired
    private TFolderMapper tFolderMapper;

    @Autowired
    private AwsS3Util awsS3Util;

    /**
     * Amazon S3にファイルを登録します
     * 
     * @param request
     * @throws AppboxStorageException
     */
    public void fileRegist(ExternalFileRegistRequest request) throws StorageException {

        // オフジェクトキー
        String objKey = "";
        try {
            if (!Strings.isNullOrEmpty(request.getFileId())) {
                // ファイルIDが入力されている場合

                // 外部サービス登録オブジェクトテーブルの検索
                TExternalServiceObject entity =
                        tExternalServiceObjectMapper.selectByPrimaryKey(request.getFileId());
                if (entity == null) {
                    throw new StorageException(Messages.E00002);
                }

                // Amazon_S3のファイルを削除
                try {
                    awsS3Util.fileDelete(entity.getFilePath());
                } catch (Exception e) {
                    throw new StorageException(Messages.E02006);
                }

                // オブジェクトキーの生成
                String filePath = entity.getFilePath();
                String folderPath = filePath.substring(0, filePath.lastIndexOf("/"));
                objKey = folderPath + "";

                // 外部サービス登録オブジェクトテーブルの更新
                // 更新レコード作成
                entity.setFilePath(objKey);
                entity.setUpdateDate(LocalDateTime.now());
                entity.setUpdateUser("user");
                int updateCnt = tExternalServiceObjectMapper.updateByPrimaryKey(entity);
                if (updateCnt != 1) {
                    throw new StorageException(Messages.E00002);
                }

            } else {
                // ファイルIDが入力されておらず、デベロッパIDと外部サービスファイルIDが入力されている場合（ファイルの登録）

                // フォルダテーブルの検索
                TFolderExample tFolderExample = new TFolderExample();
                tFolderExample.createCriteria().andDeveloperIdEqualTo(request.getDeveloperId())
                        .andFolderGroupEqualTo(1);
                List<TFolder> entity = tFolderMapper.selectByExample(tFolderExample);
                if ((entity == null) || (entity.size() > 1)) {
                    throw new StorageException(Messages.E00002);
                }

                // オブジェクトキーの生成
                objKey = entity.get(0).getS3ObjectKey() + "/" + StorageConstant.FOLDER_EXCEPTFILES
                        + "/" + request.getApiKbn() + "/" + request.getExceptId() + "/"
                        + request.getFileName();
            }

            // Amazon_S3にファイルを登録
            try {
                awsS3Util.fileRegist(objKey, request.getUploadFile());
            } catch (Exception e) {
                throw new StorageException(Messages.E02006);
            }

            if (!Strings.isNullOrEmpty(request.getFileId())) {
                // ファイルIDが入力されておらず、デベロッパIDと外部サービスファイルIDが入力されている場合（ファイルの登録）

            }

        } catch (Exception e) {
            throw new StorageException(Messages.E00004);
        }
    }
}
