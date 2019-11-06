package jp.co.fnj.storage.api.exception;

/**
 * ストレージ例外
 * 
 * @author yamauchi
 *
 */
public class StorageRuntimeException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public StorageRuntimeException() {
        super();
    }

    public StorageRuntimeException(String message) {
        super(message);
    }

    public StorageRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
