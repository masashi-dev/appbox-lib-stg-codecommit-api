package jp.co.fnj.storage.api.service.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.custom.FileGetListMapper;
import jp.co.fnj.storage.api.entity.model.custom.FileListEntity;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.file.FileGetListRequest;
import jp.co.fnj.storage.api.model.file.FileGetListResponse;

/**
 * ファイル一覧取得APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileGetListService<REQUEST_BODY extends FileGetListRequest, RESPONSE extends List<FileGetListResponse>> {

  /** ファイル一覧取得APIマッパー */
  @Autowired
  FileGetListMapper fileGetListMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // 検索処理を実施
    List<FileListEntity> list = fileGetListMapper.selectGetFileList(requestBody.getFolder_id());

    // 何かしらのチェック処理
    if ("2".equals(requestBody.getMansion_id())) {
      throw new StorageRuntimeException(Messages.E05001);
    }

    // レスポンス成型して返却
    return (RESPONSE) List.of(new FileGetListResponse().setFile_file_id(list.get(0).toString()),
        new FileGetListResponse().setFile_file_id("2"));
  }

}
