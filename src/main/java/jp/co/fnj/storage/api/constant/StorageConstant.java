package jp.co.fnj.storage.api.constant;

import org.springframework.stereotype.Component;

@Component
public final class StorageConstant {

    /** ブランケット名 */
    public static final String BUCKET_NAME = "test";

    /** フォルダ階層(EXCEPTFILES) */
    public static final String FOLDER_EXCEPTFILES = "EXCEPTFILES";

    /** AWSログインユーザID */
    public static final String AWS_LOGIN_USER_ID = "loginUser";
}
