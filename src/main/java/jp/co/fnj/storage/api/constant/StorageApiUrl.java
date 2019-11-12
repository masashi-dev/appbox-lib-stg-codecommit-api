package jp.co.fnj.storage.api.constant;

import org.springframework.stereotype.Component;

@Component
public final class StorageApiUrl {

	public static final String STORAGEACCESS = "/storageaccess";

	// ファイル管理
	public static final String FILE_GET_LIST = "/lib/filemanagement/{folder_id}";

	// 表示順更新
	public static final String SORT_ORDER_UPDATE = "/lib/filemanagement/update";  // TODO:URLが確定次第修正する

}
