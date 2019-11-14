package jp.co.fnj.storage.api.model.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイルダウンロードAPIレスポンス.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileDownloadResponse {

  /** ファイル */
  private String file_name;

  /** ファイル */
  private String file;
}
