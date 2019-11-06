package jp.co.fnj.storage.api.exception;

/**
 * ストレージ例外
 * 
 * @author yamauchi
 *
 */
public class StorageException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public StorageException() {
        super();
    }

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
