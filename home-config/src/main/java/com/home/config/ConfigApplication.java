package com.home.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * home 配置中心
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-06 15:49
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args){
        SpringApplication.run(ConfigApplication.class,args);
    }
}
