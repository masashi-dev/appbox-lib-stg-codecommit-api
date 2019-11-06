package jp.co.fnj.storage.api.filter.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import jp.co.fnj.storage.api.model.auth.StorageUser;
import lombok.extern.slf4j.Slf4j;

/**
 * 認証を行う。
 * 
 * @author yamauchi
 *
 */
@Slf4j
@Configuration
public class StorageAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
//    private AppboxPlatformApiClient appboxPlatformApiClient;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        StorageUser appboxPlatformMgrUser = (StorageUser) authentication.getPrincipal();

        try {
            // PF(API)の認証機能を呼び出す
            /*
             * AuthAuthorizeRequest authAuthorizeRequest = new AuthAuthorizeRequest();
             * authAuthorizeRequest.setLoginId(appboxPlatformMgrUser.getLoginId());
             * authAuthorizeRequest.setLoginPassword(appboxPlatformMgrUser.getPassword());
             * 
             * HttpEntity<AuthAuthorizeResponse> authResponse =
             * appboxPlatformApiClient.authorize(authAuthorizeRequest);
             * 
             * // トークンをユーザー情報に設定 appboxPlatformMgrUser.setIdToken(authResponse.getBody().getIdToken());
             * appboxPlatformMgrUser.setAccessToken(authResponse.getBody().getAccessToken());
             * appboxPlatformMgrUser.setRefreshToken(authResponse.getBody().getRefreshToken());
             */
        } catch (Exception ex) {
            throw new BadCredentialsException("Authentication Error", ex);
        }

        try {
            /*
             * // PF(API)のユーザー情報取得機能を呼び出す HttpEntity<AuthMgraccountsUserinfoResponse> userResponse =
             * appboxPlatformApiClient.authMgraccountsUserinfo(appboxPlatformMgrUser);
             * 
             * // ユーザー名をユーザー情報に設定 appboxPlatformMgrUser.setUserName(userResponse.getBody().getName());
             */
        } catch (Exception ex) {
            throw new BadCredentialsException("Authentication Error", ex);
        }

        return new UsernamePasswordAuthenticationToken(appboxPlatformMgrUser, appboxPlatformMgrUser.getPassword(),
                appboxPlatformMgrUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
