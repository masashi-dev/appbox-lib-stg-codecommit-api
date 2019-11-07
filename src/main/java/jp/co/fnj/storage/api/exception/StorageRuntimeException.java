package jp.co.fnj.storage.api.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * ストレージ例外
 * 
 * @author yamauchi
 *
 */
public class StorageRuntimeException extends NestedRuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public StorageRuntimeException() {
		super("");
	}

	public StorageRuntimeException(String message) {
		super(message);
	}

	public StorageRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
