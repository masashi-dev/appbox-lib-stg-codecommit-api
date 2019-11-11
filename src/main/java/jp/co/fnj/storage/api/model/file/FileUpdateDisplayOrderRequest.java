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
public class FileUpdateDisplayOrderRequest {

  /** 表示順ID */
  @NotNull
  @Size(max = 14)
  private String sort_order_id;

  /** 表示順 */
  @NotNull
  private Integer sort_order;

}
