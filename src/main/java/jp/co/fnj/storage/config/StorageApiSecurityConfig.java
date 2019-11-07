package jp.co.fnj.storage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import jp.co.fnj.storage.filter.auth.StorageApiLogoutHandler;
import jp.co.fnj.storage.filter.auth.StorageAuthenticationProvider;

/**
 * PF管理画面のセキュリティ設定(spring securityの設定)
 * 
 * @author yamauchi
 *
 */
@Configuration
@EnableWebSecurity
public class StorageApiSecurityConfig extends WebSecurityConfigurerAdapter {

	// 認証処理の実態
	@Autowired
	private StorageAuthenticationProvider appboxPlatformAuthenticationProvider;

	// ログアウト時のPF(API)呼び出し
	@Autowired
	private StorageApiLogoutHandler appboxPlatformWebLogoutHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/vendors/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * // TODO:一旦無効 http.csrf().disable();
		 * 
		 * // セッション管理を行う。 http.sessionManagement();
		 * 
		 * http.authorizeRequests()
		 * .antMatchers(AppboxPlatformWebUrl.URL_SIGNIN).permitAll()
		 * .antMatchers(AppboxPlatformWebUrl.PREFIX +
		 * "/**").hasAnyAuthority(RoleAuthType.ROLE_PF_MANAGEMENT_SERVICE_PFADMIN.name()
		 * ) .anyRequest().authenticated() .and() // ログインしていない場合、ログイン画面に遷移させる
		 * .formLogin() // ログイン画面のURL .loginPage(AppboxPlatformWebUrl.URL_LOGIN) .and()
		 * .logout() .logoutUrl(AppboxPlatformWebUrl.URL_LOGOUT)
		 * .logoutSuccessUrl(AppboxPlatformWebUrl.URL_LOGIN)
		 * .addLogoutHandler(appboxPlatformWebLogoutHandler)
		 * .invalidateHttpSession(true) .deleteCookies("JSESSIONID");
		 * 
		 * AppboxPlatformWebAuthenticationFilter authFilter = new
		 * AppboxPlatformWebAuthenticationFilter(); // ログイン画面のログインボタン押下時に呼ばれるURL
		 * authFilter.setRequiresAuthenticationRequestMatcher(new
		 * AntPathRequestMatcher(AppboxPlatformWebUrl.URL_SIGNIN,
		 * HttpMethod.POST.name()));
		 * authFilter.setAuthenticationManager(authenticationManagerBean()); //
		 * ログイン失敗時の遷移先 authFilter.setAuthenticationFailureHandler(new
		 * SimpleUrlAuthenticationFailureHandler(AppboxPlatformWebUrl.URL_LOGIN +
		 * "?error=true")); // ログイン後の遷移先を設定
		 * SavedRequestAwareAuthenticationSuccessHandler successHandler = new
		 * SavedRequestAwareAuthenticationSuccessHandler();
		 * successHandler.setDefaultTargetUrl(AppboxPlatformWebUrl.URL_DASHBOARD);
		 * authFilter.setAuthenticationSuccessHandler(successHandler);
		 * 
		 * authFilter.setUsernameParameter("username");
		 * authFilter.setPasswordParameter("password");
		 * 
		 * http.addFilterAt(authFilter, AppboxPlatformWebAuthenticationFilter.class);
		 */

		// TODO:一旦無効
		http.csrf().disable().formLogin().disable();
		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated();

	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws Exception
	// {
	// auth.authenticationProvider(appboxPlatformAuthenticationProvider);
	// }
}
