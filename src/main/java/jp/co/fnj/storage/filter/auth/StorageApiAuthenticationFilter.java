package jp.co.fnj.storage.filter.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jp.co.fnj.storage.model.auth.StorageUser;
import lombok.extern.slf4j.Slf4j;

/**
 * ストレージ画面の認証フィルター
 * 
 * @author yamauchi
 *
 */
@Slf4j
public class StorageApiAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // ログインフォームから受け取ったパラメータでユーザー情報を作成します。
        StorageUser appboxPlatformMgrUser;
        try {
            appboxPlatformMgrUser = new StorageUser(obtainUsername(request), obtainPassword(request));
        } catch (Exception ex) {
            throw new BadCredentialsException("Authentication Error", ex);
        }

        // トークンの作成
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(appboxPlatformMgrUser, appboxPlatformMgrUser.getPassword());

        // 後続の認証処理へ(AppboxPlatformAuthenticationProviderへ)
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
