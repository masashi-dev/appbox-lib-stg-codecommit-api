package jp.co.fnj.storage.api.testutility;

import java.io.InputStream;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.springframework.core.io.Resource;
import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

/**
 * EXCEL形式のデータセットを読み込むためのクラス.
 *
 */
public class XlsDataSetLoader extends AbstractDataSetLoader {

  @Override
  protected IDataSet createDataSet(Resource resource) throws Exception {

    System.out.println("load EXCEL.:" + resource.getURL());

    try (InputStream inputStream = resource.getInputStream()) {
      return new XlsDataSet(inputStream);
    }
  }

}
