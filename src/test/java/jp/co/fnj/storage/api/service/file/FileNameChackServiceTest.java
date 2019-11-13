package jp.co.fnj.storage.api.service.file;

import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import jp.co.fnj.storage.api.model.filecheck.FileNameCheckRequest;
import jp.co.fnj.storage.api.model.filecheck.FileNameCheckResponse;
import jp.co.fnj.storage.api.service.filecheck.FileNameCheckService;
import jp.co.fnj.storage.api.testutility.XlsDataSetLoader;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class,})
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileNameChackServiceTest {

  // テスト対象クラス
  @Autowired
  FileNameCheckService<FileNameCheckRequest, FileNameCheckResponse> target;

  // その他準備
  @Autowired
  HttpServletRequest request;

  @Autowired
  HttpServletResponse response;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    // セッション情報のスタブなどを設定する
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Transactional
  @Rollback
  @DatabaseSetup(value = "/testdata/service/FileNameChackServiceTest/setup-tables.xlsx")
  @Test
  public void ファイル登録時のチェック_NG() {

    // input
    FileNameCheckRequest input = new FileNameCheckRequest();
    input.setFile_id(null); // ファイルIDなし＝フォルダ内すべて
    input.setFolder_id("S03B0000000001");
    input.setFile_name("論理名１");

    // 期待値
    FileNameCheckResponse expected = new FileNameCheckResponse(true);

    // 実行
    FileNameCheckResponse actual = target.execute(request, response, input);

    // 検証
    assertEquals(expected, actual);
  }

  @Transactional
  @Rollback
  @DatabaseSetup(value = "/testdata/service/FileNameChackServiceTest/setup-tables.xlsx")
  @Test
  public void ファイル登録時のチェック_OK() {

    // input
    FileNameCheckRequest input = new FileNameCheckRequest();
    input.setFile_id(null); // ファイルIDなし＝フォルダ内すべて
    input.setFolder_id("S03B0000000001");
    input.setFile_name("論理名まだなし");

    // 期待値
    FileNameCheckResponse expected = new FileNameCheckResponse(false);

    // 実行
    FileNameCheckResponse actual = target.execute(request, response, input);

    // 検証
    assertEquals(expected, actual);
  }

  @Transactional
  @Rollback
  @DatabaseSetup(value = "/testdata/service/FileNameChackServiceTest/setup-tables.xlsx")
  @Test
  public void ファイル更新時のチェック_NG() {

    // input
    FileNameCheckRequest input = new FileNameCheckRequest();
    input.setFile_id("S03A0000000002"); //
    input.setFolder_id("S03B0000000001");
    input.setFile_name("論理名１");

    // 期待値
    FileNameCheckResponse expected = new FileNameCheckResponse(true);

    // 実行
    FileNameCheckResponse actual = target.execute(request, response, input);

    // 検証
    assertEquals(expected, actual);
  }

  @Transactional
  @Rollback
  @DatabaseSetup(value = "/testdata/service/FileNameChackServiceTest/setup-tables.xlsx")
  @Test
  public void ファイル更新時のチェック_OK_自ファイルが重複() {

    // input
    FileNameCheckRequest input = new FileNameCheckRequest();
    input.setFile_id("S03A0000000002"); // 自ファイルのID
    input.setFolder_id("S03B0000000001");
    input.setFile_name("testfile");

    // 期待値
    FileNameCheckResponse expected = new FileNameCheckResponse(false);

    // 実行
    FileNameCheckResponse actual = target.execute(request, response, input);

    // 検証
    assertEquals(expected, actual);
  }


  @Transactional
  @Rollback
  @DatabaseSetup(value = "/testdata/service/FileNameChackServiceTest/setup-tables.xlsx")
  @Test
  public void ファイル更新時のチェック_OK_重複無し() {

    // input
    FileNameCheckRequest input = new FileNameCheckRequest();
    input.setFile_id("S03A0000000002"); // 自ファイルのID
    input.setFolder_id("S03B0000000001");
    input.setFile_name("論理名２");

    // 期待値
    FileNameCheckResponse expected = new FileNameCheckResponse(false);

    // 実行
    FileNameCheckResponse actual = target.execute(request, response, input);

    // 検証
    assertEquals(expected, actual);
  }
}

