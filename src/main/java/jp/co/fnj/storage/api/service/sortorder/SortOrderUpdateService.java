package jp.co.fnj.storage.api.service.sortorder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrderExample;
import jp.co.fnj.storage.api.exception.StorageBadRequestException;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderUpdateResponse;

/**
 * 表示順更新APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderUpdateService<REQUEST_BODY extends SortOrderUpdateRequest, RESPONSE extends SortOrderUpdateResponse> {

  /** 表示順テーブルマッパー */
  @Autowired
  TSortOrderMapper tSortOrderMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // ファイルIDまたはフォルダIDをもとに表示順テーブルから更新対象行を取得
    TSortOrderExample tSortOrderExampleForUpdate = new TSortOrderExample();
    tSortOrderExampleForUpdate.setForUpdate(true);
    if (requestBody.getFile_id() != null) {
      tSortOrderExampleForUpdate.createCriteria().andFileIdEqualTo(requestBody.getFile_id());
    } else {
      tSortOrderExampleForUpdate.createCriteria().andFolderIdEqualTo(requestBody.getFolder_id());
    }
    List<TSortOrder> listForUpdate = tSortOrderMapper.selectByExample(tSortOrderExampleForUpdate);
    if (listForUpdate.size() == 0) {
      // 更新対象行を取得できなかった場合は例外
      // TODO:メッセージIDとメッセージ内容をdevelopで一括対応したのち更新する
      throw new StorageBadRequestException(Messages.E05001);
    }
    TSortOrder tSortOrderUpdate = listForUpdate.get(0);

    // 更新する項目を設定
    tSortOrderUpdate.setFileId(requestBody.getFile_id());
    tSortOrderUpdate.setFolderId(requestBody.getFolder_id());
    tSortOrderUpdate.setSortOrder(requestBody.getSort_order());
    tSortOrderUpdate.setUpdateUser("tetuser"); // TODO:未整備のため別途対応
    tSortOrderUpdate.setUpdateDate(LocalDateTime.now());
    // 更新処理を実施
    tSortOrderMapper.updateByPrimaryKey(tSortOrderUpdate);


    // 表示順を更新したファイルまたはフォルダの親フォルダIDに紐付くファイル・フォルダを取得
    TSortOrderExample tSortOrderExampleForNumbering = new TSortOrderExample();
    tSortOrderExampleForNumbering.setForUpdate(true);
    tSortOrderExampleForNumbering.createCriteria()
        .andParentFolderIdEqualTo(tSortOrderUpdate.getParentFolderId());
    List<TSortOrder> listForNumbering =
        tSortOrderMapper.selectByExample(tSortOrderExampleForNumbering);
    // 取得した一覧を表示順の値でソートした後に再付番し、更新処理を実施
    Collections.sort(listForNumbering,
        ((tmpRec1, tmpRec2) -> (tmpRec2.getSortOrder()) - (tmpRec1.getSortOrder())));
    int numbering = 2;
    for (TSortOrder tmpRec : listForNumbering) {
      tmpRec.setSortOrder(numbering);
      tmpRec.setUpdateUser("tetuser"); // TODO:未整備のため別途対応
      tmpRec.setUpdateDate(LocalDateTime.now());
      tSortOrderMapper.updateByPrimaryKey(tmpRec);
      numbering += 2;
    }



    // レスポンス項目なし
    return;
  }

}
