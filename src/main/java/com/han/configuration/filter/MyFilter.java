package com.han.configuration.filter;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName MyFilter.java
 * @Description TODO
 * @createTime 2021年03月11日 22:18:00
 */
@Configuration
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
