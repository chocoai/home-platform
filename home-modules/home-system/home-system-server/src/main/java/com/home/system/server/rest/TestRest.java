package com.home.system.server.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-25 11:01
 **/
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestRest {

    @Value("${evn}")
    private String evn;

    @GetMapping
    public String getEnv(){
        return evn;
    }

}
