package jp.co.fnj.storage.api.model.bookmark;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * お気に入り登録リクエスト
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BookmarkRegistRequest {
  /** ファイルID */
  @Size(max = 14)
  private String file_id;

  /** フォルダID */
  @Size(max = 14)
  private String folder_id;
}
