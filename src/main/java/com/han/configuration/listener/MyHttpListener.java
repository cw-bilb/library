package com.han.configuration.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName MyHttpListener.java
 * @Description TODO
 * @createTime 2021年03月12日 01:20:00
 */
@WebListener
public  class MyHttpListener implements HttpSessionListener {
    private static int online;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        online++;
        se.getSession().setAttribute("count",online);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        online--;
        se.getSession().setAttribute("count",online);
    }
}
