package jp.co.fnj.storage.api.service.bookmark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.generat.TBookmarkMapper;
import jp.co.fnj.storage.api.entity.model.generat.TBookmarkExample;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkDeleteResponse;


/**
 * お気に入り削除APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class BookmarkDeleteService<REQUEST_BODY extends BookmarkDeleteRequest, RESPONSE extends BookmarkDeleteResponse> {
  /** お気に入りテーブルマッパー */
  @Autowired
  TBookmarkMapper tBookmarkMapper;

  @Transactional(RollbackFo = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {
    
    // TODO セッション情報を取得し設定する
    String userId = null;
    String bookmarkId = requestBody.getBookmark_id();
    
    // ユーザーIDとお気に入りIDから削除対象を取得
    TBookmarkExample tBookmarkExampleForDelete = new TBookmarkExample();
    tBookmarkExampleForDelete.createCriteria()
      .andUserIdEqualTo(userId)
      .andBookmarkIdEqualTo(bookmarkId);
      
    // 削除処理を実施
    tBookmarkMapper.deleteByExample(tBookmarkExampleForDelete); 
    // レスポンス項目なし
    return;
  }
}
