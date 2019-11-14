package jp.co.fnj.storage.api.service.foldercheck;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import jp.co.fnj.storage.api.entity.mapper.generat.TFolderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import jp.co.fnj.storage.api.model.foldercheck.FolderNameCheckRequest;
import jp.co.fnj.storage.api.model.foldercheck.FolderNameCheckResponse;

/**
 * フォルダー論理名重複チェックAPIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class FolderNameCheckService<REQUEST_BODY extends FolderNameCheckRequest, RESPONSE extends FolderNameCheckResponse> {

  @Autowired
  private TFolderMapper tFolderMapper;

  @Transactional(rollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    // TODO セッションから取得
    String developerId = "";
    String mansionId = "";
    String userId = "";

    TFolderExample folderCriteria = new TFolderExample();
    folderCriteria.createCriteria().andFolderNameEqualTo(requestBody.getFolder_id())
        .andParentFolderIdEqualTo(requestBody.getParent_folder_id()).andDeleteFlgEqualTo(false)
        .andPrivateFlgEqualTo(false);
    if (requestBody.getFolder_id() != null) {
      folderCriteria.getOredCriteria().get(0).andFolderIdNotEqualTo(requestBody.getFolder_id());
    }
    if (developerId != null) {
      folderCriteria.getOredCriteria().get(0).andDeveloperIdEqualTo(developerId);
    }
    if (mansionId != null) {
      folderCriteria.getOredCriteria().get(0).andMansionIdEqualTo(mansionId);
    }
    // A AND ( B OR C) のクエリが書けないため、(A AND B) OR (A AND C) にしてる
    TFolderExample.Criteria orCriteria =
        folderCriteria.createCriteria().andFolderNameEqualTo(requestBody.getFolder_id())
            .andParentFolderIdEqualTo(requestBody.getParent_folder_id()).andDeleteFlgEqualTo(false)
            .andCreateUserEqualTo(userId);
    if (requestBody.getFolder_id() != null) {
      orCriteria.andFolderIdNotEqualTo(requestBody.getFolder_id());
    }
    if (developerId != null) {
      orCriteria.andDeveloperIdEqualTo(developerId);
    }
    if (mansionId != null) {
      orCriteria.andMansionIdEqualTo(mansionId);
    }
    folderCriteria.or(orCriteria);
    List<TFolder> tFolders = tFolderMapper.selectByExample(folderCriteria);

    if (CollectionUtils.isEmpty(tFolders)) {
      return (RESPONSE) new FolderNameCheckResponse(Boolean.FALSE);
    }
    return (RESPONSE) new FolderNameCheckResponse(Boolean.TRUE);
  }

}
