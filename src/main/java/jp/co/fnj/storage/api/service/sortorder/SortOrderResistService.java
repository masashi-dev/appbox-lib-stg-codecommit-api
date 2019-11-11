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
import jp.co.fnj.storage.api.model.sortorder.SortOrderResistRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderResistResponse;

/**
 * 表示順更新APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderResistService<REQUEST_BODY extends SortOrderResistRequest, RESPONSE extends List<SortOrderResistResponse>> {

  /** 表示順テーブルマッパー */
  @Autowired
  TSortOrderMapper tSortOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
    REQUEST_BODY requestBody) {

	// ファイルIDまたはフォルダIDをもとに表示順テーブルを絞り込み
	TSortOrderExample tSortOrderExample = new TSortOrderExample();
	if (requestBody.getFile_id() != null) {
	  tSortOrderExample.createCriteria().andFileIdEqualTo(requestBody.getFile_id());
	} else {
	  tSortOrderExample.createCriteria().andFolderIdEqualTo(requestBody.getFolder_id());
	}

	// 更新する項目を設定
	TSortOrder tSortOrder = new TSortOrder();
	tSortOrder.setFileId(requestBody.getFile_id());
	tSortOrder.setFolderId(requestBody.getFolder_id());
	tSortOrder.setSortOrder(requestBody.getSort_order());

	// 更新処理を実施
	tSortOrderMapper.updateByExampleSelective(tSortOrder, tSortOrderExample);

	// レスポンス項目なし
	return;
  }

}
