package jp.co.fnj.storage.api.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.fnj.storage.api.exception.StorageBadRequestException;
import jp.co.fnj.storage.api.model.error.StorageApiErrorResponse;
//import jp.co.fnj.appbox.platform.api.model.error.AppboxPlatformApiErrorResponse;
//import jp.co.fnj.appbox.platform.common.service.AppboxPlatformMessageSource;
//import jp.co.fnj.appbox.platform.constant.AppboxPlatformMessageConstant;
//import jp.co.fnj.appbox.platform.web.api.client.AppboxPlatformApiClientException;
//import jp.co.fnj.appbox.platform.web.exception.AppboxPlatformWebBadRequestException;
import lombok.extern.slf4j.Slf4j;

/**
 * APIの例外ハンドラー
 * 
 * @author yamauchi
 *
 */
@RestControllerAdvice
@Slf4j
public class StoraegeApiExceptionHandler extends ResponseEntityExceptionHandler {

//　例外の出力先をクラウドウォッチへ変更する
	
//    @Autowired
//    private StorageMessageSource messageSource;
//    
//    /**
//     * API呼び出し時の例外
//     * 
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(StorageApiClientException.class)
//    public ResponseEntity<Object> handleBadRequestException(AppboxPlatformApiClientException ex, WebRequest request) {
//        // ログを出力する
//        log.debug(ex.getMessage(), ex);
//        return this.handleExceptionInternal(ex, ex.getApiErrorResponse(), null, ex.getStatusCode(), request);
//    }
    
    /**
     * 400 Bad Request
     * WebApiのバリデーションエラー(※PF-FNC-170:ログ管理:画面操作ログ送信のみ）
     * 
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(StorageBadRequestException.class)
    public ResponseEntity<Object> handleWebBadRequestException(StorageBadRequestException ex, WebRequest request) {
        // ログを出力する
        log.debug(ex.getMessage(), ex);
        
        StorageApiErrorResponse errorResponse = new StorageApiErrorResponse();
        errorResponse.setErrorCode(ex.getMessageId());
        //errorResponse.setErrorMessage(messageSource.getMessage(ex.getMessageId()));
        //errorResponse.setFieldErrorList(ex.getFieldErrorList());
        
        return this.handleExceptionInternal(ex, errorResponse, null, HttpStatus.BAD_REQUEST, request);
    }
    
    
//    /**
//     * 想定外の例外
//     * 
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//        
//        // エラーログを出力する
//        log.error(ex.getMessage(), ex);
//
//        AppboxPlatformApiErrorResponse errorResponse = new AppboxPlatformApiErrorResponse();
//        errorResponse.setErrorCode(AppboxPlatformMessageConstant.E00001);
//        errorResponse.setErrorMessage(messageSource.getMessage(AppboxPlatformMessageConstant.E00001));
//
//        return this.handleExceptionInternal(ex, errorResponse, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }

    /**
     * 例外共通内部処理
     */
   @Override
   protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
       if (request != null) {
           return super.handleExceptionInternal(ex, body, headers, status, request);
       } else {
           return new ResponseEntity<>(body, headers, status);
       }
   }
}
