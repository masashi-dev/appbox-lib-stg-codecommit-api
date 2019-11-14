package jp.co.fnj.storage.api.model.folder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 移動先フォルダリスト取得APIレスポンス.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FolderGetDestinationListResponse {
  /** フォルダID */
  private String folder_id;

  /** (フォルダTBL)論理フォルダパス */
  private String folder_path;
}
