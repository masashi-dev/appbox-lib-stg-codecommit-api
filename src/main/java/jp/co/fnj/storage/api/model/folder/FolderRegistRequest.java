package jp.co.fnj.storage.api.model.folder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * フォルダ作成APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FolderRegistRequest {

  /** フォルダ名 */
  @NotNull
  @Size(min = 1, max = 1024)
  private String folder_name;

  /** 公開フラグ */
  @NotNull
  @Pattern(regexp = "^true|false$")
  private String private_flg;

  public Boolean getPrivate_Flg() {
    return Boolean.valueOf(private_flg);
  }

  /** 説明 */
  @Size(max = 500)
  private String explanatory_text;

  /** 親フォルダID */
  @NotNull
  @Size(max = 14)
  private String parent_folder_id;

}
