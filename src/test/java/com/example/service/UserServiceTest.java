package com.example.service;


import com.example.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Date;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertFalse(b2);
    }


    @Test
    public void findUserByUserName() {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void loginSuccess() {
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        userService.saveLog(user);
    }
}

