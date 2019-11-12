package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル名変更APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileUpdateRequest {

  /** ファイルID */
  @NotNull
  @Size(max = 14)
  private String file_id;

  /** 論理ファイル名 */
  @NotNull
  @Size(min = 1, max = 1024)
  private String file_name;

  /** 検索ワード */
  @NotNull
  @Size(max = 14)
  private String folder_id;
}
