package jp.co.fnj.storage.api.model.filecheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル論理名重複チェックAPIレスポンス.
 *
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileNameCheckResponse {

  /** 重複判定 */
  private Boolean check_rslt;

}
