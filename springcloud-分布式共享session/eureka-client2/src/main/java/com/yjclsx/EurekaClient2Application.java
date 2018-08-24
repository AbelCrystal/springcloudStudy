package com.yjclsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 启动总入口
 * @author yjc
 * 2017年10月9日
 */
@EnableRedisHttpSession
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient2Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaClient2Application.class, args);
    }
    
}