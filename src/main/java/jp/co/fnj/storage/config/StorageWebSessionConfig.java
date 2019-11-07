//package jp.co.fnj.storage.config;
//
//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.CookieSerializer;
//import org.springframework.session.web.http.DefaultCookieSerializer;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * ストレージ画面のセッション設定(spring sessionの設定)
// * 
// * @author yamauchi
// *
// */
//@EnableRedisHttpSession
//public class StorageWebSessionConfig {
//
//    /**
//     * セッションidをCookieに設定
//     * 
//     * @return
//     */
//    @Bean
//    public CookieSerializer cookieSerializer() {
//        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//
//        // HTTPSで動作している場合はHTTPSでないとCookieを返さないようにする
//        // serializer.setUseSecureCookie(true);
//
//        // CookieへのアクセスはHTTPプロトコルに限定（SSHとかはNG）
//        serializer.setUseHttpOnlyCookie(true);
//
//        return serializer;
//    }
//
//    /**
//     * DBセッションのトランザクション管理
//     * 
//     * @param dataSource
//     * @return
//     */
//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//}
