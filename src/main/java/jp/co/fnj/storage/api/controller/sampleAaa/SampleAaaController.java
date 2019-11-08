package jp.co.fnj.storage.api.controller.sampleAaa;

import java.io.IOError;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************
 *
 * XXX-XXX-XXX ユーザー情報取得コントローラー
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@RestController
public class SampleAaaController {

	@Autowired
	public Validator validator;


    /**
     * ユーザー情報取得
     *
     * 指定したユーザーIDのユーザー情報を取得します.
     *
     * @param user_id ユーザーID
     * @return UserInfoResponse ユーザー情報
     * @throws IOException 
     */
    @RequestMapping("/sample1")
    public ResponseEntity<SampleAaaResponse> getUserInfo(
    		@RequestParam(value="user_id", defaultValue="99999") String user_id
	) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "heaer1-value");


    	// リクエストパラメータをリクエストクラスに設定
    	SampleAaaRequest req = new SampleAaaRequest(user_id);
    	
    	// バリデーションエラーがある場合はエラーを返却
    	Set<ConstraintViolation<SampleAaaRequest>> errorResult = validator.validate(req);
    	if (0 < errorResult.size()) {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    	}


    	// ユーザー情報を取得
    	// {ここでDBやファイルから情報を取得する}

    	// ユーザー情報を取得できなかった場合はエラーを返却
    	// ※if文の条件は見直して下さい
    	if ("333".equals(req.getUser_id())) {
    		return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
    	}
    	

    	// レスポンスを返却
    	// 上記で取得した値などを使ってレスポンスを組み立てる
    	SampleAaaResponse res = new SampleAaaResponse(req.getUser_id(), "田中", "太郎", 18);
        return new ResponseEntity<>(res, headers, HttpStatus.OK);

    }

}

/**
 * [サンプル解説]
 *   GETリクエストで1つのキーをもとに1つのデータを返却するサンプルです.
 * 
 *   "@RequestMapping"アノテーションで指定したURLへのリクエストが来た場合に処理します.
 *
 *   URLにリクエストパラメーラを指定した場合は指定した値が利用され、
 *   リクエストパラメータを省略した場合はdefaultValueで指定した値が利用されます.
 *
 *   （例）http://localhost:8081/sample                → user_id："99999"（デフォルト値）
 *         http://localhost:8081/sample?user_id=12345  → user_id："12345"
 */
