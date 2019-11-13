package jp.co.fnj.storage.api.model.filecheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/********************************************************************
 *
 * FileNameCheckレスポンスクラス
 *
 * @author R.Kokubun
 * @version 1.0
 *
 *******************************************************************/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileNameCheckResponse {

  /** 重複判定 */
  private Boolean check_rslt;

}
