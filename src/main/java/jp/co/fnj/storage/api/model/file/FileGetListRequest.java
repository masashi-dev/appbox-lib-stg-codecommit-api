package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル一覧取得APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileGetListRequest {

  /** フォルダID */
  @NotNull
  @Size(max = 14)
  private String folder_id;

  /** マンションID */
  @Size(max = 14)
  private String mansion_id;
}
