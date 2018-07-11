package com.home.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * home-platform 认证服务器Main
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-10 18:08
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.home.system.client","com.home.authorization"})
@EnableFeignClients(basePackages = {"com.home.system.client"})
@EnableResourceServer
public class AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class,args);
    }
}
