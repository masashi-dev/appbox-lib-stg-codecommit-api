package jp.co.fnj.storage.api.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * ストレージ例外
 * 
 * @author yamauchi
 *
 */
public class StorageBadRequestException extends NestedRuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public StorageBadRequestException() {
		super("");
	}

	public StorageBadRequestException(String message) {
		super(message);
	}

	public StorageBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getMessageId() {
		return getMessageId();
	}
}
