package com.han.configuration.handlerUrl;

import com.han.dao.Admin;
import com.han.dao.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName MyHandler.java
 * @Description TODO
 * @createTime 2021年03月11日 10:17:00
 */
public class MyHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截开始---------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (user == null && admin == null) {
            response.sendRedirect("/");
        }
        System.out.println("拦截通过----------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截放行----------");
    }
}
