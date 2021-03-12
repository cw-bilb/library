package com.han;

import com.han.dao.User;
import com.han.mapper.UserMapper;
import com.han.service.IUserService;
import com.han.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;

@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {

        User user = new User();
        user.setUserName("a");
        user.setUserPwd("a");
        user.setUserEmail("123@123.com");
        userService.insertUser(user);
        int i = 1 / 0;

    }

}
