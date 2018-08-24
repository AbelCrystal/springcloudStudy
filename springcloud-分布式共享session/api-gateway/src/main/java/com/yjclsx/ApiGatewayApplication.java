package com.yjclsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 启动总入口
 * @author yjc
 * 2017年10月9日
 */
@EnableRedisHttpSession	
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    
}