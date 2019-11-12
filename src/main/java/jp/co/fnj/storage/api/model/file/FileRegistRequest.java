package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル登録APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileRegistRequest {

  /** ファイル名 */
  @NotNull
  @Size(max = 1024)
  private String file_name;

  /** フォルダ名 */
  @NotNull
  @Size(max = 14)
  private String folder_id;

  /** アップロードファイル（Base64で受ける） */
  private String upload_file;
}
