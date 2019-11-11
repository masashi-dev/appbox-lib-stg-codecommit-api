package jp.co.fnj.storage.api.controller.sample;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/********************************************************************
 *
 * SampleAaaリクエストクラス
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SampleRequest {

  /** ユーザーID */
  @NotNull
  @Size(max = 3)
  private String user_id;

  /** パラメータ */
  @NotNull
  private String test_param;
}
