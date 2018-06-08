package com.home.customer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * home客户系统
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-07 14:35
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServerApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomerServerApplication.class,args);
    }
}
