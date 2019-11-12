package jp.co.fnj.storage.api.constant;

import org.springframework.stereotype.Component;

@Component
public final class StorageApiUrl {

  public static final String STORAGEACCESS = "/storageaccess";

  // 表示順登録
  public static final String SORT_ORDER_RESIST = "/lib/filemanagement/insert"; // TODO:適切なURLを指定する
  // 表示順更新
  public static final String SORT_ORDER_UPDATE = "/lib/filemanagement/update"; // TODO:URLが確定次第修正する
}
