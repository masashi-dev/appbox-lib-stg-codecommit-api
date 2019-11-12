package jp.co.fnj.storage.api.service.sortorder;

import java.time.LocalDateTime;
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
 * 表示順登録APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderResistService<REQUEST_BODY extends SortOrderResistRequest, RESPONSE extends List<SortOrderResistResponse>> {

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


  /** 表示順テーブルマッパー */
  @Autowired
  TSortOrderMapper tSortOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // リクエストの親フォルダIDを条件とし表示順テーブルをグルーピングする
    TSortOrderExample tSortOrderExampleParentGrp = new TSortOrderExample();
    // TODO:グループ条件を実装する
    List<TSortOrder> listParentGrp = tSortOrderMapper.selectByExample(tSortOrderExampleParentGrp);



    // 登録する項目を設定
    TSortOrder tSortOrder = new TSortOrder();
    tSortOrder.setSortOrderId("12345"); // TODO:採番した値をinsertするよう実装する
    tSortOrder.setParentFolderId(requestBody.getParent_folder_id());

    // 登録区分に応じて設定する項目を切り替え
    if (requestBody.getEntry_devision() == ENTRY_DEVISION.FILE.getValue()) {
      tSortOrder.setFileId(requestBody.getFile_folder_id());
    } else {
      tSortOrder.setFolderId(requestBody.getFile_folder_id());
    }

    if (true) {
      // グループの中で最も大きい表示順＋初期値を設定
      tSortOrder.setSortOrder(1111 + SORT_ORDER_INIT_VAL);
    } else {
      // 初期値を設定
      tSortOrder.setSortOrder(SORT_ORDER_INIT_VAL);
    }


    tSortOrder.setCreateUser("testuser"); // TODO:未整備事項のため別途実装
    tSortOrder.setUpdateDate(LocalDateTime.now());
    // 登録処理を実施
    tSortOrderMapper.insert(tSortOrder);


    // レスポンス項目なし
    return;
  }

}
