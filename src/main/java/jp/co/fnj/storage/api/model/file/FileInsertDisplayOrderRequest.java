package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 表示順更新APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileInsertDisplayOrderRequest {

  /** ファイルID */
  @Size(max = 14)
  private String file_id;

  /** フォルダID */
  @Size(max = 14)
  private String folder_id;

  /** 並び順 */
  @NotNull
  private int sort_order;

}
