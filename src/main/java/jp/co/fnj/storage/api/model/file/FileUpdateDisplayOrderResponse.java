package jp.co.fnj.storage.api.model.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 表示順更新APIレスポンス.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileUpdateDisplayOrderResponse {

  // TODO:実装する
	
  /** 表示順ID */
  private String sort_order_id;

  /** 表示順 */
  private Integer sort_order;
  
  /** 更新ユーザID */
  private String update_user_id;

}
