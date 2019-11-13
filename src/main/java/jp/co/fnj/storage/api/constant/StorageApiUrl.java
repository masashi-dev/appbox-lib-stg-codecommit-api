package jp.co.fnj.storage.api.constant;

import org.springframework.stereotype.Component;

@Component
public final class StorageApiUrl {

  public static final String STORAGEACCESS = "/storageaccess";

  // ファイル管理
  public static final String FILE_GET_LIST = "/lib/filemanagement/{folder_id}";
  // 表示順登録
  public static final String SORT_ORDER_RESIST = "/lib/filemanagement/insert"; // TODO:適切なURLを指定する
  // 表示順更新
  public static final String SORT_ORDER_UPDATE = "/lib/filemanagement/update"; // TODO:URLが確定次第修正する
  // 表示順削除
  public static final String SORT_ORDER_DELETE = "/lib/filemanagement/delete"; // TODO:URLが確定次第修正する

	//お気に入り
	public static final String BOOKMARK_DELETE = "/lib/bookmark";  // TODO:URLが確定次第修正する
	public static final String BOOKMARK_REGIST = "/lib/bookmark"; // TODO:URLが確定次第修正する
}
