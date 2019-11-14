package jp.co.fnj.storage.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * AWSの設定
 * 
 * @author yamauchi
 *
 */
@Configuration
@PropertySource(value = {"classpath:AwsS3Setting.properties"})
public class StorageAwsConfig {

}
