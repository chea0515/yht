package com.cc.yht.module.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AuthenticationConfig extends WebMvcConfigurerAdapter {

    /**
     * sources
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor())
                .addPathPatterns(
                        "/api/user/**",    // user信息接口
                        "/api/score/**",   // 用户积分接口
                        "/api/wx/**"       // 微信常用操作接口(不包括官方调用认证接口)
                );
    }

    /**
     * CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
