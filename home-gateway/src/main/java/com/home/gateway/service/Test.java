package com.home.gateway.service;

import org.springframework.util.AntPathMatcher;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-20 15:01
 **/
public class Test {
    public static void main(String[] args) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();

       boolean flag = antPathMatcher.match("/system/role/has/111","/system/role/*");
        System.out.println(flag);
    }
}
