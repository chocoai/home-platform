package com.home.authorization.config;

import com.home.authorization.config.token.HomeRedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 * 认证服务器逻辑
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-10 18:27
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("home")
                //  123456
                // Spring Security 5.0 新特性  验证密码会根据 {bcrypt} 来确认密码类型
                .secret("{bcrypt}$2a$10$frYqZ2FzdlysBmoZjn/EX.t3vxxZi4PXMX/5kEqCLpzmlizUR0Feu")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 资源服务器使用秘钥需要身份认证
        security.tokenKeyAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(Arrays.asList());

        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(redisTokenStore());
//                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Bean
    public TokenStore redisTokenStore() {
        HomeRedisTokenStore tokenStore = new HomeRedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix("home_");
        return tokenStore;
    }

//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        // 生产JWT的秘钥
//        converter.setSigningKey("home");
//        return converter;
//    }

//    @Bean
//    public TokenEnhancer tokenEnhancer(){
//
//    }
}
