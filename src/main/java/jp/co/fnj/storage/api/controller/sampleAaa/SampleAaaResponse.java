package jp.co.fnj.storage.api.controller.sampleAaa;

import lombok.Data;

/********************************************************************
 *
 * SampleAaaレスポンスクラス
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@Data
public class SampleAaaResponse {

	/** ユーザーID */
    private final String user_id;

    /** 姓 */
    private final String sei;    

    /** 名 */
    private final String mei;

    /** 年齢 */
    private final int age;

}
