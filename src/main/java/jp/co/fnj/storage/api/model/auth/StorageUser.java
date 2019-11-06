package jp.co.fnj.storage.api.model.auth;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import lombok.Getter;

/**
 * ストレージ画面ユーザー
 * 
 * @author yamauchi
 *
 */
@Getter
public class StorageUser extends User {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ログインID
     */
    private String loginId;

    /**
     * パスワード
     */
    private String password;

    /**
     * ユーザー名(PF(API)から取得)
     */
    private String userName;

    /**
     * IDトークン(PF(API)から取得)
     */
    private String idToken;

    /**
     * アクセストークン(PF(API)から取得)
     */
    private String accessToken;

    /**
     * リフレッシュトークン(PF(API)から取得)
     */
    private String refreshToken;

    /**
     * コンストラクタ
     */
    public StorageUser(String loginId, String password) {
        // TODO:権限を考える。
        super(loginId, password, AuthorityUtils.createAuthorityList("ROLE_XXXXX"));
        this.loginId = loginId;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
