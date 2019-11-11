package jp.co.fnj.storage.api.service.sortorder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrderExample;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateResponse;

/**
 * 表示順更新APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderUpdateService<REQUEST_BODY extends SortOrderUpdateRequest, RESPONSE extends List<SortOrderUpdateResponse>> {

  /** 表示順テーブルマッパー */
  @Autowired
  TSortOrderMapper tSortOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
    REQUEST_BODY requestBody) {
	  
	// ファイルIDまたはフォルダIDをもとに表示順テーブルから更新対象行を取得
	TSortOrderExample tSortOrderExample = new TSortOrderExample();
	tSortOrderExample.setForUpdate(true);
	if (requestBody.getFile_id() != null) {
	  tSortOrderExample.createCriteria().andFileIdEqualTo(requestBody.getFile_id());
	} else {
	  tSortOrderExample.createCriteria().andFolderIdEqualTo(requestBody.getFolder_id());
	}
	List<TSortOrder> list = tSortOrderMapper.selectByExample(tSortOrderExample);

	// 更新する項目を設定
	TSortOrder tSortOrder = list.get(0);
	tSortOrder.setFileId(requestBody.getFile_id());
	tSortOrder.setFolderId(requestBody.getFolder_id());
	tSortOrder.setSortOrder(requestBody.getSort_order());
	tSortOrder.setUpdateUser("tetuser");  // TODO:未整備のため別途対応
//	tSortOrder.setUpdateDate(updateDate);  // TODO:現在時刻を設定

	// 更新処理を実施
	tSortOrderMapper.updateByPrimaryKey(tSortOrder);

	// レスポンス項目なし
	return;
  }

}
