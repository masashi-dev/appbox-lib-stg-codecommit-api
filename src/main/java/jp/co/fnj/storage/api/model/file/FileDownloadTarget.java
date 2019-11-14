package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jdk.jfr.BooleanFlag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイルダウンロードAPIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileDownloadTarget {

  /** id */
  @NotNull
  @Size(max = 14)
  private String id;

  /** ファイルフラグ */
  @NotNull
  @BooleanFlag
  private Boolean file_flg;

}
