package jp.co.fnj.storage.api.controller.sampleAaa;

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

    /**
     * ユーザー情報取得
     *
     * 指定したユーザーIDのユーザー情報を取得します.
     *
     * @param user_id ユーザーID
     * @return UserInfoResponse ユーザー情報
     */
    @RequestMapping("/sample1")
    public SampleAaaResponse getUserInfo(@RequestParam(value="user_id", defaultValue="99999") long user_id) {

    	// ユーザー情報を取得
    	// {ここでDBやファイルから情報を取得する}
    	
    	// レスポンスを生成
    	// 上記で取得した値などを使ってレスポンスを組み立てる
    	SampleAaaResponse res = new SampleAaaResponse(user_id, "田中", "太郎", 18);
    	
    	// レスポンスを返却
        return res;

    }

}

/**
 * [サンプル解説]
 *   1つのキーをもとに1つのデータを返却するサンプルです.
 * 
 *   "@RequestMapping"アノテーションで指定したURLへのリクエストが来た場合に処理します.
 *
 *   URLにリクエストパラメーラを指定した場合は指定した値が利用され、
 *   リクエストパラメータを省略した場合はdefaultValueで指定した値が利用されます.
 *
 *   （例）http://localhost:8081/sample                → user_id："99999"（デフォルト値）
 *         http://localhost:8081/sample?user_id=12345  → user_id："12345"
 */
