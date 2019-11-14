package jp.co.fnj.storage.api.service.sortorder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fnj.storage.api.constant.Messages;
import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrderExample;
import jp.co.fnj.storage.api.exception.StorageBadRequestException;
import jp.co.fnj.storage.api.model.sortorder.SortOrderDeleteRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderDeleteResponse;

/**
 * 表示順削除APIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderDeleteService<REQUEST_BODY extends SortOrderDeleteRequest, RESPONSE extends SortOrderDeleteResponse> {
	/** 表示順テーブルマッパー */
	@Autowired
	TSortOrderMapper tSortOrderMapper;

	@Transactional(RollbackFo = Throwable.class)
	public void execute(HttpServletRequest request, HttpServletResponse response,
			REQUEST_BODY requestBody) {
	    
	    // 削除処理を実施
	    tSortOrderMapper.deleteByPrimaryKey(requestBody.getSort_order_id());
	    
	    // レスポンス項目なし
	    return;
	}
}
