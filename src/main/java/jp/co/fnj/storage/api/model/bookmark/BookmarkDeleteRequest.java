package jp.co.fnj.storage.api.model.bookmark;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * お気に入り削除リクエストクラス.
 * 
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BookmarkDeleteRequest {

  /** お気に入りID */
  @Size(max = 14)
  @NotNull
  private String bookmark_id;
}
