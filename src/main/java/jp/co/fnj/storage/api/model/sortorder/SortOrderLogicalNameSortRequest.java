package jp.co.fnj.storage.api.model.sortorder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 0~9並び替えAPIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SortOrderLogicalNameSortRequest {

  /** フォルダID */
  @NotNull
  @Size(max = 14)
  private String folder_id;

}
