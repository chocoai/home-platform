package com.home.employee.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 16:33
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeApplication {
    public static void main(String[] args){
        SpringApplication.run(EmployeeApplication.class,args);
    }
}
