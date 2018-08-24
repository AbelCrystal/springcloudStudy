package com.yjclsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动总入口
 * @author yjc
 * 2017年10月9日
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
    
}