package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル物理名重複チェックAPIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class S3FileNameCheckRequest {

  /** ファイルID */
  @Size(max = 14)
  private String file_id;

  /** 物理ファイル名 */
  @NotNull
  @Size(max = 1024)
  private String s3_file_name;

  /** フォルダID */
  @NotNull
  @Size(max = 14)
  private String folder_id;

}
