package com.yjclsx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置网关过滤器
 * @author yjc
 * 2017年4月14日
 */
@Configuration
public class ApiGatewayConfig {
	
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
