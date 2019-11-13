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
import jp.co.fnj.storage.api.model.filecheck.FileNameCheckRequest;
import jp.co.fnj.storage.api.model.filecheck.FileNameCheckResponse;

/**
 * ファイル論理名重複チェックAPIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FileNameCheckService<REQUEST_BODY extends FileNameCheckRequest, RESPONSE extends FileNameCheckResponse> {

  @Autowired
  private TFileMapper tFileMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    TFileExample fileCriteria = new TFileExample();
    fileCriteria.createCriteria().andFileNameEqualTo(requestBody.getFile_name())
        .andFolderIdEqualTo(requestBody.getFolder_id()).andDeleteFlgEqualTo(false);
    if (requestBody.getFile_id() != null) {
      fileCriteria.getOredCriteria().get(0).andFileIdNotEqualTo(requestBody.getFile_id());
    }
    List<TFile> tFiles = tFileMapper.selectByExample(fileCriteria);

    if (CollectionUtils.isEmpty(tFiles)) {
      return (RESPONSE) new FileNameCheckResponse(Boolean.FALSE);
    }
    return (RESPONSE) new FileNameCheckResponse(Boolean.TRUE);
  }

}
