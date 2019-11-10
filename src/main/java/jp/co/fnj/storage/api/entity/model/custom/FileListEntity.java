package jp.co.fnj.storage.api.entity.model.custom;

import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ファイル一覧エンティティ.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileListEntity {

  /** フォルダ情報 */
  private TFolder tFolder;

  /** ファイル情報 */
  private TFile tFile;
}
