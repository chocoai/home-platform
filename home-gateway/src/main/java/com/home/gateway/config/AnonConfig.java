package com.home.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务器不需要 token 验证的接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 17:45
 **/
@Configuration
@ConfigurationProperties(prefix = "custom.security.urls")
public class AnonConfig {

    private List<String> anon = new ArrayList<>();

    public List<String> getAnon() {
        return anon;
    }

    public void setAnon(List<String> anon) {
        this.anon = anon;
    }
}
