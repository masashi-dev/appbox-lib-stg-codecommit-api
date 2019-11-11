package jp.co.fnj.storage.api.service.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.custom.SampleMapper;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.sample.SampleRequest;
import jp.co.fnj.storage.api.model.sample.SampleResponse;

/**
 * サンプルサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
// TODO <REQUEST_BODY extends SampleResponse, RESPONSE extends SampleResponse>
// の部分はやめるかも
public class SampleService<REQUEST_BODY extends SampleRequest, RESPONSE extends SampleResponse> {

  /** サンプルAPIマッパー */
  @Autowired
  SampleMapper sampleMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // 検索処理を実施
    sampleMapper.selectHoge(requestBody.getUser_id());

    // 何かしらのチェック処理
    if ("2".equals(requestBody.getUser_id())) {
      throw new StorageRuntimeException(Messages.E05001);
    }

    // レスポンス成型して返却
    return (RESPONSE) new SampleResponse();
  }

}
