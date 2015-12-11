package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.services.security.LoginInfo;
import com.xioq.kestral.services.security.User;
import com.xioq.kestral.services.security.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by bronwen.cassidy on 24/06/2015
 */
@Transactional
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