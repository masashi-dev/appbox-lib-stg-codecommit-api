package jp.co.fnj.storage.api.model.viewer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル拡張子チェックAPIレスポンス.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileExtensionCheckResponse {

  /** 拡張子 */
  private String extension;

  /** 表示種別(1:txt,2:pdf,3:img,4:audio,5:video) */
  private Integer display_type;
}
