package jp.co.fnj.storage.api.service.sortorder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.model.sortorder.SortOrderResistRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderResistResponse;

/**
 * 表示順登録APIサービス.
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

	// 悲観ロック
	// TODO:実装する




	// 登録する項目を設定
	TSortOrder tSortOrder = new TSortOrder();
	tSortOrder.setParentFolderId(requestBody.getParent_folder_id());

	// 登録区分に応じて設定する項目を切り替え
	if (requestBody.getEntry_devision() == 0) {
	  tSortOrder.setFileId(requestBody.getFile_folder_id());
	} else {
      tSortOrder.setFolderId(requestBody.getFile_folder_id());
	}

	// 親フォルダIDを条件として表示順テーブルをグルーピングする


//	// リクエストの親フォルダIDに値が設定されている場合は親フォルダIDを条件とし表示順テーブルをグルーピングする
//	if (requestBody.getParent_folder_id().isEmpty()) {
//      // TODO:実装する
//      tSortOrder.setSortOrder(2);
//	} else {
//      // 親フォルダIDが未指定の場合
//      // 表示順には初期値を設定
//	  tSortOrder.setSortOrder(2);
//	}

	tSortOrder.setCreateUser("testuser");  // TODO:未整備事項のため別途実装
//	tSortOrder.setCreateDate();  // TODO:現在時刻を取得する


	// 登録処理を実施
	tSortOrderMapper.insert(tSortOrder);

	// レスポンス項目なし
	return;
  }

}
