package jp.co.fnj.storage.api.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import jp.co.fnj.storage.api.entity.mapper.generat.TSequenceMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSequence;
import jp.co.fnj.storage.api.entity.model.generat.TSequenceExample;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import lombok.RequiredArgsConstructor;

/**
 * シーケンス管理.
 *
 */
@Service
@RequiredArgsConstructor
public class SequenceService {

  /** ID名列挙体 */
  private enum ID_NAME {
    /** 共通_ログNo */
    COMMON_LOG_NO("S01A"),
    /** ファイル管理_ファイルID */
    FILE_FILE_ID("S03A"),
    /** ファイル管理_表示順ID */
    FILE_SORT_ORDER("S03B"),
    /** フォルダ管理_フォルダID */
    FOLDER_FOLDER_ID("S04A"),
    /** フォルダ管理_親フォルダID */
    FOLDER_PARENT_FOLDER_ID("S04B"),
    /** お気に入り管理_お気に入りID */
    BOOKMARK_BOOKMARK_ID("S05A"),
    /** 権限管理_権限ID */
    AUTHORITY_AUTHORITY_ID("S06A");

    private String value;

    private ID_NAME(String value) {
      this.value = value;
    }

    public String getValue() {
      return this.value;
    }

  }

  private final TSequenceMapper tSequenceMapper;

  /**
   * 表示順テーブルの主キーを生成する.
   * 
   * @return sort_order_id
   */
  @Transactional(rollbackFor = Throwable.class)
  public String createSortOrderId() {
    return ID_NAME.FILE_SORT_ORDER.getValue() + getNextVal(ID_NAME.FILE_SORT_ORDER);
  }


  /**
   * 連番を発番する.
   *
   * @param argIdName
   * @return
   */
  private String getNextVal(ID_NAME argIdName) {

    // 引数に指定されたID名をもとにロックを取得
    TSequenceExample criteria = new TSequenceExample();
    criteria.createCriteria().andIdNameEqualTo(argIdName.getValue());
    criteria.setForUpdate(true);

    List<TSequence> tSequences;
    try {
      tSequences = tSequenceMapper.selectByExample(criteria);
    } catch (PessimisticLockingFailureException e) {
      // 悲観ロックに失敗した場合は例外をthrow（タイムアウト時間超過も含む）
      throw e;
    }

    if (CollectionUtils.isEmpty(tSequences)) {
      // 該当レコードが存在しない場合は例外をthrow
      throw new StorageRuntimeException();
    }

    // 採番を更新
    TSequence update = tSequences.get(0);
    update.setSequenceValue(update.getSequenceValue() + 1);
    update.setUpdateUser("testuser"); // TODO:未整備事項のため別途実装
    update.setUpdateDate(LocalDateTime.now());
    tSequenceMapper.updateByPrimaryKey(update);

    return String.format("%010d", update.getSequenceValue());

  }

}
