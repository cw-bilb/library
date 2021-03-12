package com.han.configuration;

import com.han.configuration.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.FilterRegistration;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName MyFilterConfigurer.java
 * @Description TODO
 * @createTime 2021年03月11日 22:19:00
 */
@Configuration
public class MyFilterConfigurer {
    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistration(){
        FilterRegistrationBean<MyFilter> FilterRegistrationBean =  new FilterRegistrationBean<>();
        FilterRegistrationBean.setFilter(new MyFilter());
        FilterRegistrationBean.addUrlPatterns("/");
        return FilterRegistrationBean;
    }
}
