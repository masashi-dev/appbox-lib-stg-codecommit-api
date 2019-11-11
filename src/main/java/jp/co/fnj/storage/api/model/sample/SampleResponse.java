package jp.co.fnj.storage.api.model.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/********************************************************************
 *
 * Sampleレスポンスクラス
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SampleResponse {

  /** ユーザーID */
  private String user_id;

  /** 姓 */
  private String sei;

  /** 名 */
  private String mei;

  /** 年齢 */
  private int age;

}
