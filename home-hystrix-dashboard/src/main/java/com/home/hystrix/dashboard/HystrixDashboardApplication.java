package com.home.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-26 18:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.home.system.client"})
@EnableFeignClients(basePackages = {"com.home.system.client"})
// 开启断路器 - 服务降价
@EnableCircuitBreaker
// 熔断可视化工具
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class,args);
    }
}
