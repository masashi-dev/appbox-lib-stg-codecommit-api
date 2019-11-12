package jp.co.fnj.storage.api.model.bookmark;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/********************************************************************
 *
 * STORAGE-FNC-024 お気に入り削除リクエストクラス
 *
 * @author
 * @version 1.0
 *
 *******************************************************************/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BookmarkDeleteRequest {

	/** お気に入りID */
	@NotNull
	@Size(max = 14)
	private String bookmark_id;
}
