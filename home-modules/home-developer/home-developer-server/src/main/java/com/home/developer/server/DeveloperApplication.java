package com.home.developer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开发商服务器启动Main
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 9:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class DeveloperApplication {
    public static void main(String[] args){
        SpringApplication.run(DeveloperApplication.class,args);
    }
}
