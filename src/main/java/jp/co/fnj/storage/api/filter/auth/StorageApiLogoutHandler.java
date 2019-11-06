package jp.co.fnj.storage.api.filter.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
//import jp.co.fnj.storage.api.client.AppboxPlatformApiClient;
import lombok.extern.slf4j.Slf4j;

/**
 * ログアウトを行います。
 * 
 * @author yamauchi
 *
 */
@Component
@Slf4j
public class StorageApiLogoutHandler implements LogoutHandler {

//    @Autowired
//    private AppboxPlatformApiClient appboxPlatformApiClient;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        try {

            // ログアウトAPIの呼び出し
            // StorageUser authUser = StorageWebUtil.getAuthenticationPrincipal();
            // appboxPlatformApiClient.authLogout(authUser);

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }


    }
}
