package jp.co.fnj.storage.api.model.folder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 移動先フォルダリスト取得APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FolderGetDestinationListRequest {

  /** フォルダID */
  @NotNull
  @Size(max = 14)
  private String folder_id;
}
