package jp.co.fnj.storage.api.entity.model.custom;

import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示順更新エンティティ.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUpdateDisplayOrderEntity {

  /** フォルダ情報 */
  private TFolder tFolder;

  /** ファイル情報 */
  private TFile tFile;

}
