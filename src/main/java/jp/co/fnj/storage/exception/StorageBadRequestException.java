package jp.co.fnj.storage.exception;

import javax.ws.rs.BadRequestException;

/**
 * ストレージ例外
 * 
 * @author yamauchi
 *
 */
public class StorageBadRequestException extends BadRequestException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public StorageBadRequestException() {
        super();
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
