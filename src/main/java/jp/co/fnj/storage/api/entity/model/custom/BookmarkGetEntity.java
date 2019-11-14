package jp.co.fnj.storage.api.entity.model.custom;

import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * お気に入り取得のエンティティ
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkGetEntity {
  /** お気に入りID */
  private String bookmarkId;
  
  /** ファイル情報 */
  private TFile tFile;

  /** フォルダ情報 */
  private TFolder tFolder;
}
