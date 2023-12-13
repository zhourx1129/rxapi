package com.zhourx.rxapiclientsdk;

import com.zhourx.rxapiclientsdk.client.RxApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhourx
 * @Description: 客户端配置
 * @Date: 2023/12/5 22:26
 */
@Configuration
@ConfigurationProperties(prefix = "rxapi.client")
@Data
@ComponentScan
public class RxApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public RxApiClient rxApiCient(){
        return new RxApiClient(accessKey,secretKey);
    }
}
