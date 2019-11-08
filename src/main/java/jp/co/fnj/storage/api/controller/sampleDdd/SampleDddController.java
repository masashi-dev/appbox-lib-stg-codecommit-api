package jp.co.fnj.storage.api.controller.sampleDdd;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fnj.storage.api.exception.StorageRuntimeException;

/********************************************************************
 *
 * XXX-XXX-XXX ユーザー情報取得コントローラー（GETリクエスト版）
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@RestController
@Validated
public class SampleDddController {

	@Autowired
	public Validator validator;


    /**
     * ユーザー情報取得
     *
     * 指定したユーザーIDのユーザー情報を取得します.
     *
     * @param user_id ユーザーID
     * @param test_param 任意のパラメータ
     * @return UserInfoResponse ユーザー情報
     */
    @RequestMapping(value = "/sample4/{user_id}/{test_param}",  method = GET)
    public ResponseEntity<SampleDddResponse> getUserInfo(
    		@NotNull @Size(max=3) @PathVariable("user_id") String user_id,
    		@PathVariable("test_param") String test_param
	) {
    	// ユーザー情報を取得
    	// {ここでDBやファイルから情報を取得する}

    	// ユーザー情報を取得できなかった場合はエラーを返却
    	// ※if文の条件は見直して下さい
    	if ("333".equals(user_id)) {
    		throw new StorageRuntimeException();
    	}
    	

    	// レスポンスを返却
    	// 上記で取得した値などを使ってレスポンスを組み立てる
    	SampleDddResponse res = new SampleDddResponse(user_id, test_param, "太郎", 18);
        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "heaer1-value");
        return new ResponseEntity<>(res, headers, HttpStatus.OK);

    }

}

/**
 * [サンプル解説]
 *   GETリクエストで複数のキーをもとに1つのデータを返却するサンプルです.
 *   キーはルートパラメータから取得します.
 * 
 *   "@RequestMapping"アノテーションで指定したURLへのリクエストが来た場合に処理します.
 *
 *   URLにルートパラメーラを指定した場合は指定した値が利用されます.
 *
 *   （例）http://localhost:8081/sample4/12345/てすと  → user_id："12345"、test_param："てすと"
 */
