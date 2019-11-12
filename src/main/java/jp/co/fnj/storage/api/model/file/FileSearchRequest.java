package jp.co.fnj.storage.api.model.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル検索APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileSearchRequest {

  /** フォルダID */
  @NotNull
  @Size(max = 14)
  private String folder_id;

  /** 検索ワード */
  @NotNull
  @Size(min = 1, max = 50)
  private String search_word;
}
