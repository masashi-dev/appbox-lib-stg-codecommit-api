package jp.co.fnj.storage.api.client;

import org.springframework.http.HttpStatus;
import jp.co.fnj.storage.exception.StorageException;
//import jp.co.fnj.storage.model.error.AppboxPlatformApiErrorResponse;
import lombok.Getter;

/**
 * Api呼び出し失敗の例外(認証固まってから修正入れる)
 * 
 * @author yamauchi
 *
 */
//@Getter
//public class AppboxPlatformApiClientException extends StorageException {
//
//    /**
//     * serialVersionUID
//     */
//    private static final long serialVersionUID = 1L;
//
//    private final HttpStatus statusCode;
//
//    private final AppboxPlatformApiErrorResponse apiErrorResponse;
//
//    /**
//     * コンストラクタ
//     * 
//     * @param message
//     * @param cause
//     * @param statusCode
//     * @param apiErrorResponse
//     */
//    public AppboxPlatformApiClientException(String message, Throwable cause, HttpStatus statusCode, AppboxPlatformApiErrorResponse apiErrorResponse) {
//        super(message, cause);
//        this.statusCode = statusCode;
//        this.apiErrorResponse = apiErrorResponse;
//    }
//
//}
