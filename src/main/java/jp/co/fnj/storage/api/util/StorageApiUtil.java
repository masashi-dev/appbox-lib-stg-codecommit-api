package jp.co.fnj.storage.api.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.exception.StorageRuntimeException;
import jp.co.fnj.storage.api.model.auth.StorageUser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class StorageApiUtil {

    private final static DateTimeFormatter YYYYMMDDHHMMSS =
            DateTimeFormat.forPattern("yyyyMMddHHmmss");
    private final static DateTimeFormatter ISO8601_DATETIME = ISODateTimeFormat.dateTimeNoMillis();

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


    /**
     * yyyyMmddHhMmSs形式の文字列をyyyy-MM-ddTHH:mm:ss形式に変換します。
     * 
     * @param yyyyMmddHhMmSs
     * @return
     */
    public final static String toIso8601DateTime(String yyyyMmddHhMmSs) {
        try {
            DateTime dt = DateTime.parse(yyyyMmddHhMmSs, YYYYMMDDHHMMSS);
            return dt.toString(ISO8601_DATETIME);
        } catch (Exception ex) {
            log.debug(ex.getMessage(), ex);
            return null;
        }
    }


    /**
     * DatemTime型をyyyy-MM-ddTHH:mm:ss形式に変換します。
     * 
     * @param datetime
     * @return
     */
    public final static String toIso8601DateTime(DateTime datetime) {
        return ISODateTimeFormat.dateTimeNoMillis().print(datetime);
    }


    /**
     * システム日時を取得します。
     * 
     * @return
     */
    public final static DateTime getSystemDate() {
        return new DateTime(System.currentTimeMillis());
    }
}