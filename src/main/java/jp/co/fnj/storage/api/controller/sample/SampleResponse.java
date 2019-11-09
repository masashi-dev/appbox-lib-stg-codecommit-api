package jp.co.fnj.storage.api.controller.sample;

import lombok.Data;

/********************************************************************
 *
 * Sampleレスポンスクラス
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@Data
public class SampleResponse {

	/** ユーザーID */
	private final String user_id;

	/** 姓 */
	private final String sei;

	/** 名 */
	private final String mei;

	/** 年齢 */
	private final int age;

}
