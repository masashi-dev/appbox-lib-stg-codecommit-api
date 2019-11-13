package jp.co.fnj.storage.api.service.sortorder;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.custom.SortOrderResistMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TSequenceMapper;
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
public class SortOrderResistService<REQUEST_BODY extends SortOrderResistRequest, RESPONSE extends SortOrderResistResponse> {

  /** 登録区分 */
  private enum ENTRY_DEVISION {
    /** ファイル */
    FILE(0),
    /** フォルダ */
    FOLDER(1);

    private int code_val;

    private ENTRY_DEVISION(int argCodeVal) {
      this.code_val = argCodeVal;
    }

    public int getValue() {
      return this.code_val;
    }
  }

  /** 表示順の初期値 */
  final private int SORT_ORDER_INIT_VAL = 2;


  @Autowired
  TSortOrderMapper tSortOrderMapper;
  @Autowired
  SortOrderResistMapper sortOrderRegistMapper;
  @Autowired
  TSequenceMapper tSequenceMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // リクエストの親フォルダIDを条件とし表示順テーブルをグルーピングする
    Integer sortOrderMax =
        sortOrderRegistMapper.selectSortOrderMax(requestBody.getParent_folder_id());

    // 登録する項目を設定
    TSortOrder tSortOrder = new TSortOrder();
    tSortOrder.setSortOrderId((String) request.getAttribute("new_sort_order_id"));
    tSortOrder.setParentFolderId(requestBody.getParent_folder_id());

    // 登録区分に応じて設定する項目を切り替え
    if (requestBody.getEntry_devision() == ENTRY_DEVISION.FILE.getValue()) {
      tSortOrder.setFileId(requestBody.getFile_folder_id());
    } else {
      tSortOrder.setFolderId(requestBody.getFile_folder_id());
    }

    // 表示順テーブルに同一の親フォルダIDを持つレコードが存在しない場合のみ初期値を設定
    // それ以外の場合は表示順の最大値＋初期値を設定
    if (sortOrderMax == null) {
      tSortOrder.setSortOrder(SORT_ORDER_INIT_VAL);
    } else {
      tSortOrder.setSortOrder(sortOrderMax + SORT_ORDER_INIT_VAL);
    }


    tSortOrder.setCreateUser("testuser"); // TODO:未整備事項のため別途実装
    tSortOrder.setUpdateDate(LocalDateTime.now());
    // 登録処理を実施
    tSortOrderMapper.insert(tSortOrder);


    // レスポンス項目なし
    return;
  }

}