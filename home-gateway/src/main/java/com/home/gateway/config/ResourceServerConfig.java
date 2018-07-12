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
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.Filter;
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


    @Autowired(required = false)
    private AnonConfig anonConfig;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private Filter validateCodeFilter;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(redisTokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 配置验证码过滤器在授权之前
        http.addFilterBefore(validateCodeFilter, AbstractAuthenticationProcessingFilter.class);

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.authorizeRequests();
        for (String anon : anonConfig.getAnon()){
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
