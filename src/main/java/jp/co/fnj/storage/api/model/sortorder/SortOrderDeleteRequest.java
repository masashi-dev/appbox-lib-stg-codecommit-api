package jp.co.fnj.storage.api.model.sortorder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 表示順削除APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SortOrderDeleteRequest {
	/** 表示順ID */
	@Size(max = 14)
	@NotNull
	private String sort_order_id;
}
