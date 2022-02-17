package com.wzy.security.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author wzy
 * @version 1.0
 **/
@Configuration
public class TokenConfig {
    //私钥，自定义的
    private String SIGNING_KEY = "uaa123";

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
        return converter;
    }
/*    //令牌存储策略
    @Bean
    public TokenStore tokenStore() {
        //内存方式，生成普通令牌
        return new InMemoryTokenStore();
    }*/
}
