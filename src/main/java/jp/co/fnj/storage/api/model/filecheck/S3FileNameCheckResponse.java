package jp.co.fnj.storage.api.model.filecheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ファイル物理名重複チェックAPIレスポンス.
 *
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class S3FileNameCheckResponse {

  /** 重複判定(true:重複あり) */
  private Boolean check_rslt;
}
