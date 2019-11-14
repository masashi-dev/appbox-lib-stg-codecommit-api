package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル/フォルダ削除ファイルリスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileDeleteTarget {

  /** id */
  @NotNull
  @Size(max = 14)
  private String id;

  /** ファイルフラグ */
  @NotNull
  @Pattern(regexp = "^true|false$")
  private String file_flg;

  public Boolean getFile_Flg() {
    return Boolean.valueOf(file_flg);
  }
}
