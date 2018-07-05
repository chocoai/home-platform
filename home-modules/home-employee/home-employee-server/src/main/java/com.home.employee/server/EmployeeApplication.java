package com.home.employee.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 员工服务Main
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 16:33
 **/
@ComponentScan({"com.home.developer.client","com.home.employee.server"})
@EnableFeignClients(basePackages = {"com.home.developer.client"})
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
