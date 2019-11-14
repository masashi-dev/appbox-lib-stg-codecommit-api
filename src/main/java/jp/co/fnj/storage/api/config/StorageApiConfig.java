package jp.co.fnj.storage.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import jp.co.fnj.storage.api.client.AppboxPlatformApiClient;

/**
 * ストレージAPIの設定
 * 
 * @author yamauchi
 *
 */
@Configuration
public class StorageApiConfig implements WebMvcConfigurer {

  /**
   * APIクライアントの設定(PF管理画面からPF(API)の呼び出し用
   * 
   * @return
   */
  // @Bean
  // public AppboxPlatformApiClient appboxPlatformApiClient() {
  //
  // SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
  // requestFactory.setConnectTimeout(5000);
  // requestFactory.setReadTimeout(3000);
  //
  // return new AppboxPlatformApiClient(new RestTemplate(requestFactory));
  // }

  // /**
  // * メッセージソース
  // *
  // * @return
  // */
  // @Bean
  // public AppboxPlatformMessageSource appboxPlatformMessageSource() {
  // return new AppboxPlatformMessageSource();
  // }
}
