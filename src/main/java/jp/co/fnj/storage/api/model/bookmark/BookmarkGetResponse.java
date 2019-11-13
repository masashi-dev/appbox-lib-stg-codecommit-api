package jp.co.fnj.storage.api.model.bookmark;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * お気に入り取得レスポンスクラス.
 *
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkGetResponse {
  /** ユーザID */
  private String user_id;
  
  /** お気に入りリスト */
  private List<BookmarkGetDetail> bookmark_list;
}
