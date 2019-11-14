package jp.co.fnj.storage.api.model.viewer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル拡張子チェックリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileExtensionCheckRequest {

  /** ファイルID */
  @NotNull
  @Size(max = 14)
  private String file_id;
}
