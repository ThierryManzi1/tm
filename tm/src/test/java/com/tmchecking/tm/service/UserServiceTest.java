package com.tmchecking.tm.service;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import com.tmchecking.tm.service.impl.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceTest
 */
@SpringJUnitWebConfig(name = "")
@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserServiceImpl userService;

   
    @Test
    public void test() {
       Mockito.when(userService.loadUserByUsername("Phili"))
              .getMock();
    }


 
}