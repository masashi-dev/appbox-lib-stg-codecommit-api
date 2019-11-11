package jp.co.fnj.storage.api.service.file;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.custom.FileUpdateDisplayOrderMapper;
import jp.co.fnj.storage.api.entity.model.custom.FileUpdateDisplayOrderEntity;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.file.FileUpdateDisplayOrderRequest;
import jp.co.fnj.storage.api.model.file.FileUpdateDisplayOrderResponse;

/**
 * 表示順更新APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileUpdateDisplayOrderService<REQUEST_BODY extends FileUpdateDisplayOrderRequest, RESPONSE extends List<FileUpdateDisplayOrderResponse>> {

  /** ファイル一覧取得APIマッパー */
  @Autowired
  FileUpdateDisplayOrderMapper fileUpdateDisplayOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // 更新処理を実施
    List<FileUpdateDisplayOrderEntity> list = fileUpdateDisplayOrderMapper.updateDisplayOrder(requestBody.getSort_order_id());

    // レスポンス成型して返却
    return (RESPONSE) List.of(new FileUpdateDisplayOrderResponse().setSort_order(1234));

//    // レスポンス成型して返却
//    return (RESPONSE) List.of(new FileUpdateDisplayOrderResponse().setUpdate_user_id("K2110031"),
//        new FileUpdateDisplayOrderResponse().setSort_order(999));
  }

}
