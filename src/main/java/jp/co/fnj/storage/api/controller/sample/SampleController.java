package jp.co.fnj.storage.api.controller.sample;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.fnj.storage.api.logic.sample.SampleLogic;

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

  @Autowired
  private SampleLogic<SampleResponse, SampleResponse> sampleLogic;

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
  public ResponseEntity<SampleResponse> sample1(HttpServletRequest request,
      HttpServletResponse response, @ModelAttribute @Validated SampleRequest requestBody) {
    // クエリパラメータは@ModelAttributeでrequestクラスとマッピングする

    sampleLogic.execute(request, response, requestBody);

    // レスポンスを返却
    // 上記で取得した値などを使ってレスポンスを組み立てる
    SampleResponse res = new SampleResponse(requestBody.getUser_id(), "田中", "太郎", 18);
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
  public ResponseEntity<SampleResponse> sample2(HttpServletRequest request,
      HttpServletResponse response, @RequestBody @Validated SampleRequest requestBody) {
    // POSTパラメータは@RequestBodyでリクエストクラストマッピングする

    // レスポンスを返却
    // 上記で取得した値などを使ってレスポンスを組み立てる
    SampleResponse res = new SampleResponse(requestBody.getUser_id(), "田中", "太郎", 18);
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
   * @param user_id ユーザーID
   * @param test_param 任意のパラメータ
   * @return UserInfoResponse ユーザー情報
   */
  @RequestMapping(value = "/sample3/{user_id}/{test_param}", method = GET)
  public ResponseEntity<SampleResponse> sample3(HttpServletRequest request,
      HttpServletResponse response, @NotNull @Size(max = 3) @PathVariable String user_id,
      @PathVariable String test_param, @ModelAttribute SampleRequest requestBody) {
    // パスパラメータは@PathVariableでマッピングする
    // また、validationはrequestBodyにいれて実施する


    // レスポンスを返却
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
  public ResponseEntity<List<SampleResponse>> sample4(
      @ModelAttribute @Validated SampleRequest request) {
    // 複数件の返却は戻り値をResponseEntity<List<ほげ>>にする

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
