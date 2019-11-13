package jp.co.fnj.storage.api.service.bookmark;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.generat.TBookmarkMapper;
import jp.co.fnj.storage.api.entity.model.generat.TBookmarkExample;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetResponse;
import jp.co.fnj.storage.api.model.file.FileGetListResponse;

/**
 * お気に入り取得APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class BookmarkGetService<REQUEST_BODY extends BookmarkGetRequest, RESPONSE extends BookmarkGetResponse> {
  /** お気に入りテーブルマッパー */
  @Autowired
  TBookmarkMapper tBookmarkMapper;

  @Transactional(noRollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {
    
    BookmarkGetResponse responseBody = null;
    
    // 全体を表示順にソートして返却
    return (RESPONSE) responseBody;
  }
}
