package jp.co.fnj.storage.api.model.sortorder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 表示順登録APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SortOrderResistRequest {

  /** ファイルID／フォルダID */
  @NotNull
  @Size(max = 14)
  private String file_folder_id;

  /** 親フォルダID */
  @NotNull
  @Size(max = 14)
  private String parent_folder_id;

  /** 登録区分 */
  @NotNull
  @Min(0)
  @Max(1)
  private Integer entry_devision;

}
