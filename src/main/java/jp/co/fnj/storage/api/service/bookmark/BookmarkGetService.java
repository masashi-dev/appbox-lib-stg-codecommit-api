package jp.co.fnj.storage.api.service.bookmark;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.custom.BookmarkGetMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TBookmarkMapper;
import jp.co.fnj.storage.api.entity.model.custom.BookmarkGetEntity;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetDetail;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkGetResponse;

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
  
  /** お気に入り取得テーブルマッパー */
  @Autowired
  private BookmarkGetMapper bookmarkGetMapper;

  @Transactional(rollbackFor = Throwable.class)
  public RESPONSE execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {
    //レスポンス用のデータを用意
    BookmarkGetResponse responseBody = new BookmarkGetResponse();
    List<BookmarkGetDetail> bookmarkList = new ArrayList<>();
    
    String userId = "12345678901234"; //TODO: セッションからユーザーIDを取得する
    
    // お気に入りファイルとフォルダの情報取得
    List<BookmarkGetEntity> bookmarkEntities = bookmarkGetMapper.selectBookmark(userId);

    //リスト作成
    for (BookmarkGetEntity bookmark : bookmarkEntities) {
      BookmarkGetDetail detail = new BookmarkGetDetail();
      detail.setBookmark_id(bookmark.getBookmarkId());
      //ファイル情報格納
      if (bookmark.getTFile() != null) {
        detail.setFile_file_id(bookmark.getTFile().getFileId());
        detail.setFile_folder_id(bookmark.getTFile().getFolderId());
        detail.setFile_file_name(bookmark.getTFile().getFileName());
        detail.setFile_s3_file_name(bookmark.getTFile().getS3FileName());
        detail.setFile_s3_objecrt_key(bookmark.getTFile().getS3ObjectKey());
        detail.setFile_file_size(bookmark.getTFile().getFileSize());
        detail.setFile_insert_user_id(bookmark.getTFile().getCreateUser());
        detail.setFile_insert_date_time(bookmark.getTFile().getCreateDate());
        detail.setFile_update_user_id(bookmark.getTFile().getUpdateUser());
        detail.setFile_update_date_time(bookmark.getTFile().getUpdateDate());
        bookmarkList.add(detail);
      }
      //フォルダ情報格納
      else if (bookmark.getTFolder() != null) {
        detail.setFolder_folder_id(bookmark.getTFolder().getFolderId());
        detail.setFolder_parent_folder_id(bookmark.getTFolder().getParentFolderId());
        detail.setFolder_folder_name(bookmark.getTFolder().getFolderName());
        detail.setFolder_s3_folder_name(bookmark.getTFolder().getS3FolderName());
        detail.setFolder_developer_id(bookmark.getTFolder().getDeveloperId());
        detail.setFolder_mansion_id(bookmark.getTFolder().getMansionId());
        detail.setFolder_s3_object_key(bookmark.getTFolder().getS3ObjectKey());
        detail.setFolder_explanatory_text(bookmark.getTFolder().getExplanatoryText());
        detail.setFolder_insert_user_id(bookmark.getTFolder().getCreateUser());
        detail.setFolder_insert_date_time(bookmark.getTFolder().getCreateDate());
        detail.setFolder_update_user_id(bookmark.getTFolder().getUpdateUser());
        detail.setFolder_update_date_time(bookmark.getTFolder().getUpdateDate());
        bookmarkList.add(detail);
      }
    }
    // 抽出された結果をレスポンスListに登録
    responseBody.setBookmark_list(bookmarkList);
    responseBody.setUser_id(userId);
    return (RESPONSE) responseBody;
  }
}
