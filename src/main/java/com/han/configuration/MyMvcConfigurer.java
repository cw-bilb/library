package com.han.configuration;

import com.han.configuration.handlerUrl.MyHandler;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName MyMvcConfigurer.java
 * @Description TODO
 * @createTime 2021年03月11日 10:18:00
 */
@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandler()).addPathPatterns("/**").excludePathPatterns("/","/css/**","/images/**",
                "/layui/**","/scripts/**","/favicon.ico",
                "/getCount"
                );
    }
}
