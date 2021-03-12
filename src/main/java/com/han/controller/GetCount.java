package com.han.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName GetCount.java
 * @Description TODO
 * @createTime 2021年03月12日 04:55:00
 */
@RestController
public class GetCount {
    @RequestMapping("/getCount")
    public String getCount(HttpSession session){
        return String.valueOf(session.getAttribute("count")) ;
    }
}
