package com.ihfplus.practice.token.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author feng.he
 * @title: InterceptorConfig
 * @projectName springboot-token
 * @description: TODO
 * @date 2020/1/4 13:57
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor());
    }
}
