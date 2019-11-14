package jp.co.fnj.storage.api.service.bookmark;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TBookmarkMapper;
import jp.co.fnj.storage.api.entity.model.generat.TBookmark;
import jp.co.fnj.storage.api.entity.model.generat.TBookmarkExample;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistResponse;


@Service
public class BookmarkRegistService<REQUEST_BODY extends BookmarkRegistRequest, RESPONSE extends BookmarkRegistResponse> {

  /** お気に入りテーブルマッパー */
  @Autowired
  TBookmarkMapper tBookmarkMapper;

  @Transactional(rollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    String userId = "12345678901234"; // TODO セッション情報を取得し設定する
    String fileId = requestBody.getFile_id();
    String folderId = requestBody.getFolder_id();
    
    // お気に入り重複チェック
    TBookmarkExample tBookmarkExample = new TBookmarkExample();
    if (fileId != null) {
      tBookmarkExample.createCriteria()
          .andUserIdEqualTo(userId)
          .andFileIdEqualTo(userId);
    } else if (folderId != null) {
      tBookmarkExample.createCriteria()
           .andUserIdEqualTo(userId)
          .andFolderIdEqualTo(userId);
    } else {
      throw new StorageRuntimeException(Messages.E04001);
    }
    long duplicateCount = tBookmarkMapper.countByExample(tBookmarkExample);

    // 重複がある場合終了
    if (duplicateCount > 0) {
      return;
    }
    
    //登録処理    
    TBookmark tBookmark = new TBookmark();
    tBookmark.setBookmarkId((String) request.getAttribute("new_bookmark_id"));
    tBookmark.setUserId(userId);
    tBookmark.setCreateUser("testuser"); // TODO:未整備事項のため別途実装
    tBookmark.setCreateDate(LocalDateTime.now());

    if (fileId != null) {
      tBookmark.setFileId(fileId);
    } else if (folderId != null) {
      tBookmark.setFolderId(folderId);
    }
    
    // 登録処理を実施
    tBookmarkMapper.insert(tBookmark);

    return;
  }
}
