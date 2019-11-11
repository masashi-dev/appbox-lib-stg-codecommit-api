package jp.co.fnj.storage.api.service.file;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
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
  TSortOrderMapper tSortOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
    REQUEST_BODY requestBody) {

	TSortOrder tSortOrder = new TSortOrder();
	tSortOrder.setSortOrderId(requestBody.getSort_order_id());
	tSortOrder.setSortOrder(requestBody.getSort_order());

	// 更新処理を実施
	tSortOrderMapper.updateByPrimaryKey(tSortOrder);

	// レスポンス成型して返却
	return;

//    // レスポンス成型して返却
//    return (RESPONSE) List.of(new FileUpdateDisplayOrderResponse().setUpdate_user_id("K2110031"),
//        new FileUpdateDisplayOrderResponse().setSort_order(999));
  }

}
