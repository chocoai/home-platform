package com.home.gateway.config;

import com.home.gateway.config.token.HomeRedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务区逻辑
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-11 18:03
 **/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final static List<String> anons = new ArrayList<>();

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(redisTokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.authorizeRequests();
        for (String anon : anons){
            expressionInterceptUrlRegistry.antMatchers(anon).permitAll();
        }

        expressionInterceptUrlRegistry
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public TokenStore redisTokenStore() {
        HomeRedisTokenStore tokenStore = new HomeRedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix("home_");
        return tokenStore;
    }
}
