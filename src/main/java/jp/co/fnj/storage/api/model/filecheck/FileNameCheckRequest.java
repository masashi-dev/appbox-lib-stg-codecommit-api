package jp.co.fnj.storage.api.model.filecheck;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/********************************************************************
 *
 * FileNameCheckリクエストクラス
 *
 * @author R.Kokubun
 * @version 1.0
 *
 *******************************************************************/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileNameCheckRequest {

  /** ファイルID */
  @Size(max = 14)
  private String file_id;

  /** 論理ファイル名 */
  @NotNull
  @Size(max = 1024)
  private String file_name;

  /** フォルダID */
  @NotNull
  @Size(max = 14)
  private String folder_id;
}
