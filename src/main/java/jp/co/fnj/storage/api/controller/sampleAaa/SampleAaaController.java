package jp.co.fnj.storage.api.controller.sampleAaa;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     */
    @RequestMapping(value = "/sample1",  method = GET)
    public ResponseEntity<SampleAaaResponse> getUserInfo(
    		@ModelAttribute @Validated SampleAaaRequest request
	) {
    	// ユーザー情報を取得
    	// {ここでDBやファイルから情報を取得する}

    	// ユーザー情報を取得できなかった場合はエラーを返却
    	// ※if文の条件は見直して下さい
    	if ("333".equals(request.getUser_id())) {
    		throw new StorageRuntimeException();
    	}

    	// レスポンスを返却
    	// 上記で取得した値などを使ってレスポンスを組み立てる
    	SampleAaaResponse res = new SampleAaaResponse(request.getUser_id(), "田中", "太郎", 18);
        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "heaer1-value");
        return new ResponseEntity<>(res, headers, HttpStatus.OK);

    }

}

/**
 * [サンプル解説]
 *   GETリクエストで1つのキーをもとに1つのデータを返却するサンプルです.
 *   キーはクエリパラメータから取得します.
 * 
 *   "@RequestMapping"アノテーションで指定したURLへのリクエストが来た場合に処理します.
 *
 *   URLにクエリパラメーラを指定した場合は指定した値が利用されます.
 *
 *   （例）http://localhost:8081/sample1?user_id=12345  → user_id："12345"
 */
