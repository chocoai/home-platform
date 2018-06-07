package com.home.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-06 15:48
 **/
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {
    public static void main(String[] args){
        SpringApplication.run(RegistryApplication.class,args);
    }
}
