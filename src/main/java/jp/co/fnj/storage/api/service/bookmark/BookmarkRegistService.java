package jp.co.fnj.storage.api.service.bookmark;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TBookmarkMapper;
import jp.co.fnj.storage.api.entity.model.generat.TBookmark;
import jp.co.fnj.storage.api.entity.model.generat.TBookmarkExample;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistRequest;
import jp.co.fnj.storage.api.model.bookmark.BookmarkRegistResponse;


@Service
public class BookmarkRegistService<REQUEST_BODY extends BookmarkRegistRequest, RESPONSE extends BookmarkRegistResponse> {
	
	/** お気に入りテーブルマッパー */
	@Autowired
	TBookmarkMapper tBookmarkMapper;
	  
	@Transactional(noRollbackFor = Throwable.class)
	public void execute(HttpServletRequest request, HttpServletResponse response, 
			REQUEST_BODY requestBody) {
		//TBookmarkExample tBookmarkExample = new TBookmarkExample();
		//tBookmarkExample.createCriteria();
		//TBookmark tBookmark = new TBookmark();
		
		//お気に入り重複チェック
		TBookmarkExample tBookmarkExample = new TBookmarkExample();
		if (requestBody.getFile_id() != null) {
			tBookmarkExample.createCriteria()
			.andUserIdEqualTo(requestBody.getUser_id())
			.andFileIdEqualTo(requestBody.getFile_id());
		} else if(requestBody.getFolder_id() != null)  {
			tBookmarkExample.createCriteria()
			.andUserIdEqualTo(requestBody.getUser_id())
			.andFolderIdEqualTo(requestBody.getFolder_id());
		} else {
			throw new StorageRuntimeException(Messages.E04001);
		}
		long duplicateCount = tBookmarkMapper.countByExample(tBookmarkExample);
		
		if (duplicateCount > 0) {
			//重複がある場合終了
			return;
		}

		//tBookmarkExample = new TBookmarkExample();

		
		// 登録する項目を設定
		TBookmark tBookmark = new TBookmark();
		if (requestBody.getFile_id() != null) {
			tBookmark.setFileId(requestBody.getFile_id());
		} else if(requestBody.getFolder_id() != null)  {
			tBookmark.setFolderId(requestBody.getFolder_id());
		}
		tBookmark.setCreateUser("testuser");  // TODO:未整備事項のため別途実装
		//tBookmark.setCreateDate(createDate);  // TODO:現在時刻を取得する


		// 登録処理を実施
		tBookmarkMapper.insert(tBookmark);
		
		return;
	  }
}