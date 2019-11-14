package jp.co.fnj.storage.api.service.filecheck;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import jp.co.fnj.storage.api.entity.mapper.generat.TFileMapper;
import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFileExample;
import jp.co.fnj.storage.api.model.filecheck.S3FileNameCheckRequest;
import jp.co.fnj.storage.api.model.filecheck.S3FileNameCheckResponse;

/**
 * ファイル物理名重複チェックサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class S3FileNameCheckService<REQUEST_BODY extends S3FileNameCheckRequest, RESPONSE extends S3FileNameCheckResponse> {

  @Autowired
  private TFileMapper tFileMapper;

  @Transactional(RollbackFo = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    TFileExample fileCriteria = new TFileExample();
    fileCriteria.createCriteria().andS3FileNameEqualTo(requestBody.getS3_file_name())
        .andFolderIdEqualTo(requestBody.getFolder_id()).andDeleteFlgEqualTo(false);
    if (requestBody.getFile_id() != null) {
      fileCriteria.getOredCriteria().get(0).andFileIdNotEqualTo(requestBody.getFile_id());
    }
    List<TFile> tFiles = tFileMapper.selectByExample(fileCriteria);

    if (CollectionUtils.isEmpty(tFiles)) {
      return (RESPONSE) new S3FileNameCheckResponse(Boolean.FALSE);
    }
    return (RESPONSE) new S3FileNameCheckResponse(Boolean.TRUE);
  }

}
