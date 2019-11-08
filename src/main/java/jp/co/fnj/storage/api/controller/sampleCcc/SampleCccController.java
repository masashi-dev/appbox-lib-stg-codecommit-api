package jp.co.fnj.storage.api.controller.sampleCcc;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
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
public class SampleCccController {

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
    @RequestMapping(value = "/sample3",  method = GET)
    public ResponseEntity<List<SampleCccResponse>> getUserInfo(
    		@RequestParam(value="user_id") String user_id
	) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "heaer1-value");


    	// リクエストパラメータをリクエストクラスに設定
    	SampleCccRequest req = new SampleCccRequest(user_id);
    	
    	// バリデーションエラーがある場合はエラーを返却
    	Set<ConstraintViolation<SampleCccRequest>> errorResult = validator.validate(req);
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
    	List<SampleCccResponse> tmp = new ArrayList<SampleCccResponse>();

    	SampleCccResponse res1 = new SampleCccResponse(req.getUser_id(), "田中", "太郎", 18);
    	tmp.add(res1);

    	SampleCccResponse res2 = new SampleCccResponse(req.getUser_id(), "伊東", "次郎", 21);
    	tmp.add(res2);

    	return new ResponseEntity<>(tmp, headers, HttpStatus.OK);

    }

}

/**
 * [サンプル解説]
 *   GETリクエストで1つのキーをもとに複数のデータを返却するサンプルです.
 *
 */
