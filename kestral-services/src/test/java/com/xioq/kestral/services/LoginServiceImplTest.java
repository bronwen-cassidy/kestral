package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.LoginInfo;
import com.xioq.kestral.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by bronwen.cassidy on 24/06/2015
 */
public class LoginServiceImplTest extends DefaultServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    @DatabaseSetup("LoginServiceImplTest.testLogin.xml")
    public void testLoginUser() throws Exception {
        User mary = loginService.loginUser(new LoginInfo("mary.mark","testing1"));
        assertEquals("Mary", mary.getFirstName());
    }
}