package jp.co.fnj.storage.api.entity.model.custom;

import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ファイルおよび関連するフォルダエンティティ.（1:1）
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileAndRelatedFolderInfoEntity {

  /** ファイル情報 */
  private TFile tFile;

  /** フォルダ情報 */
  private TFolder tFolder;

}
