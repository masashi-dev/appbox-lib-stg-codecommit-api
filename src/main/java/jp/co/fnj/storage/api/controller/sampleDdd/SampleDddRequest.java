package jp.co.fnj.storage.api.controller.sampleDdd;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/********************************************************************
 *
 * SampleAaaリクエストクラス
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@Data
public class SampleDddRequest {

	/** ユーザーID */
	@NotNull
	@Size(max=3)
    private final String user_id;

}
