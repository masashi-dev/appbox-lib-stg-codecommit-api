package jp.co.fnj.storage.api.model.foldercheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 論理フォルダ名重複チェックAPIレスポンス.
 *
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FolderNameCheckResponse {

  /** 重複判定 */
  private Boolean check_rslt;

}
