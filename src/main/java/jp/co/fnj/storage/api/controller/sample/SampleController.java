package jp.co.fnj.storage.api.controller.sample;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fnj.storage.api.exception.StorageRuntimeException;

/********************************************************************
 *
 * XXX-XXX-XXX ユーザー情報取得コントローラー
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@RestController
public class SampleController {

	/*
	 * [サンプル解説] GETリクエストで1つのキーをもとに1つのデータを返却するサンプルです. キーはクエリパラメータから取得します.
	 * 
	 * "@RequestMapping"アノテーションで指定したURLへのリクエストが来た場合に処理します.
	 *
	 * URLにクエリパラメーラを指定した場合は指定した値が利用されます.
	 *
	 * （例）http://localhost:8081/sample1?user_id=12345 → user_id："12345"
	 */
	/**
	 * ユーザー情報取得
	 *
	 * 指定したユーザーIDのユーザー情報を取得します.
	 *
	 * @param user_id ユーザーID
	 * @return UserInfoResponse ユーザー情報
	 */
	@RequestMapping(value = "/sample1", method = GET)
	public ResponseEntity<SampleResponse> sample1(@ModelAttribute @Validated SampleRequest request) {
		// ユーザー情報を取得
		// {ここでDBやファイルから情報を取得する}

		// ユーザー情報を取得できなかった場合はエラーを返却
		// ※if文の条件は見直して下さい
		if ("333".equals(request.getUser_id())) {
			throw new StorageRuntimeException();
		}

		// レスポンスを返却
		// 上記で取得した値などを使ってレスポンスを組み立てる
		SampleResponse res = new SampleResponse(request.getUser_id(), "田中", "太郎", 18);
		HttpHeaders headers = new HttpHeaders();
		headers.add("header1", "heaer1-value");
		return new ResponseEntity<>(res, headers, HttpStatus.OK);

	}

	/*
	 * [サンプル解説] POSTリクエストのサンプルです.
	 *
	 */
	/**
	 * ユーザー情報取得
	 *
	 * 指定したユーザーIDのユーザー情報を取得します.
	 *
	 * @param user_id ユーザーID
	 * @return UserInfoResponse ユーザー情報
	 */
	@RequestMapping(value = "/sample2", method = POST)
	public ResponseEntity<SampleResponse> sample2(@RequestBody @Validated SampleRequest request) {
		// ユーザー情報を取得
		// {ここでDBやファイルから情報を取得する}

		// ユーザー情報を取得できなかった場合はエラーを返却
		// ※if文の条件は見直して下さい
		if ("333".equals(request.getUser_id())) {
			throw new StorageRuntimeException();
		}

		// レスポンスを返却
		// 上記で取得した値などを使ってレスポンスを組み立てる
		SampleResponse res = new SampleResponse(request.getUser_id(), "田中", "太郎", 18);
		HttpHeaders headers = new HttpHeaders();
		headers.add("header1", "heaer1-value");
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}

	/*
	 * [サンプル解説] パスパラメータを取得するサンプルです.
	 *
	 */
	/**
	 * ユーザー情報取得
	 *
	 * 指定したユーザーIDのユーザー情報を取得します.
	 *
	 * @param user_id    ユーザーID
	 * @param test_param 任意のパラメータ
	 * @return UserInfoResponse ユーザー情報
	 */
	@RequestMapping(value = "/sample3/{user_id}/{test_param}", method = GET)
	public ResponseEntity<SampleResponse> sample3(@NotNull @Size(max = 3) @PathVariable("user_id") String user_id,
			@PathVariable("test_param") String test_param) {
		// ユーザー情報を取得
		// {ここでDBやファイルから情報を取得する}

		// ユーザー情報を取得できなかった場合はエラーを返却
		// ※if文の条件は見直して下さい
		if ("333".equals(user_id)) {
			throw new StorageRuntimeException();
		}

		// レスポンスを返却
		// 上記で取得した値などを使ってレスポンスを組み立てる
		SampleResponse res = new SampleResponse(user_id, test_param, "太郎", 18);
		HttpHeaders headers = new HttpHeaders();
		headers.add("header1", "heaer1-value");
		return new ResponseEntity<>(res, headers, HttpStatus.OK);

	}

	/*
	 * [サンプル解説] 複数のデータ（配列）を返却するサンプルです.
	 *
	 */
	/**
	 * ユーザー情報取得
	 *
	 * 指定したユーザーIDのユーザー情報を取得します.
	 *
	 * @param user_id ユーザーID
	 * @return UserInfoResponse ユーザー情報
	 */
	@RequestMapping(value = "/sample4", method = GET)
	public ResponseEntity<List<SampleResponse>> sample4(@ModelAttribute @Validated SampleRequest request) {
		// ユーザー情報を取得
		// {ここでDBやファイルから情報を取得する}

		// ユーザー情報を取得できなかった場合はエラーを返却
		// ※if文の条件は見直して下さい
		if ("333".equals(request.getUser_id())) {
			throw new StorageRuntimeException();
		}

		// レスポンスを返却
		// 上記で取得した値などを使ってレスポンスを組み立てる
		List<SampleResponse> tmp = new ArrayList<SampleResponse>();
		SampleResponse res1 = new SampleResponse(request.getUser_id(), "田中", "太郎", 18);
		tmp.add(res1);
		SampleResponse res2 = new SampleResponse(request.getUser_id(), "伊東", "次郎", 21);
		tmp.add(res2);
		HttpHeaders headers = new HttpHeaders();
		headers.add("header1", "heaer1-value");
		return new ResponseEntity<>(tmp, headers, HttpStatus.OK);

	}
}
