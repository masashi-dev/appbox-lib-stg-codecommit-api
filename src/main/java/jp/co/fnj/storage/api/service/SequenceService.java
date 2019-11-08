package jp.co.fnj.storage.api.service;

import java.util.List;

import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jp.co.fnj.storage.api.entity.mapper.generat.TSequenceMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSequence;
import jp.co.fnj.storage.api.entity.model.generat.TSequenceExample;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SequenceService {

	// TSequenceテーブルのMappeをインジェクション
	private final TSequenceMapper tSequenceMapper;

	/**
	 * Fileテーブルの主キーを生成
	 * 
	 * @return file_id
	 */
	@Transactional(rollbackFor = Throwable.class)
	public String createFileId() {

		// TODO Enum化とかしたい
		String name = "ID_NAME";
		String prefix = "03A";
		return getNextVal(name, prefix);
	}

	private String getNextVal(String name, String prefix) {
		// criteria（検索条件）の生成
		TSequenceExample criteria = new TSequenceExample();
		criteria.createCriteria().andIdNameEqualTo(name);
		criteria.setForUpdate(true);

		List<TSequence> tSequences;
		try {
			tSequences = tSequenceMapper.selectByExample(criteria);
		} catch (CannotAcquireLockException e) {
			// TODO ロック取得エラー
			throw e;
		}

		if (CollectionUtils.isEmpty(tSequences)) {
			// TODO 0件の場合システムエラー
		}

		// 採番を更新
		TSequence update = tSequences.get(0);
		update.setSequenceValue(update.getSequenceValue() + 1);
		tSequenceMapper.updateByPrimaryKey(update);

		return String.format("%11d", update.getSequenceValue());

	}
}
