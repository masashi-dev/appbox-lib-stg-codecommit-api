package jp.co.fnj.storage.api.model.foldercheck;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 論理フォルダ名重複チェックAPIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FolderNameCheckRequest {

  /** フォルダID */
  @Size(max = 14)
  private String folder_id;

  /** 論理フォルダ名 */
  @NotNull
  @Size(max = 1024)
  private String folder_name;

  /** 親フォルダID */
  @NotNull
  @Size(max = 14)
  private String parent_folder_id;
}
