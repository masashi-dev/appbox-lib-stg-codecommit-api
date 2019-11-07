package jp.co.fnj.storage.util;

//import org.joda.time.DateTime;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import jp.co.fnj.storage.exception.StorageException;
import jp.co.fnj.storage.exception.StorageRuntimeException;
import jp.co.fnj.storage.model.auth.StorageUser;

public final class StorageApiUtil {

	/**
	 * 認証情報を取得します。
	 * 
	 * @return
	 * @throws StorageException
	 */
	public static StorageUser getAuthenticationPrincipal() throws StorageException {

		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			Authentication authentication = context.getAuthentication();
			if (authentication != null) {
				Object principal = authentication.getPrincipal();
				if (principal instanceof StorageUser) {
					return (StorageUser) principal;
				}
			}
		}
		// 認証エラー
		throw new StorageRuntimeException();
	}

}