package com.xioq.kestral.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.LoginInfo;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.security.auth.login.FailedLoginException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bronwen.cassidy on 24/06/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class ProviderServiceImplTest {

    @Autowired
    ProviderService providerService;

    @Autowired
    LoginService loginService;

    @Test
    @DatabaseSetup("ProviderServiceImplTest.testFind.xml")
    public void testFindAll() throws Exception {
        List<Provider> providers = providerService.findAll(-1L);
        assertEquals(1, providers.size());
        Provider provider = providers.get(0);
        assertEquals("OBrian", provider.getUser().getSecondName());
    }
    @Test
    @DatabaseSetup("ProviderServiceImplTest.testAdd.xml")
    public void testAddProvider() {

        Provider p = new Provider();
        User u = new User();
        LoginInfo li = new LoginInfo("niall.groark", "numnum");

        u.setFirstName("Sally");
        u.setSecondName("Partridge");
        u.setContactEmail("niall.groark@gmail.com");
        u.setUserType(User.PROVIDER_TYPE);
        u.setCompany(new Company(-1L));
        p.setUser(u);

        Provider newP = providerService.save(p);

        Provider found = providerService.findById(newP.getId());

        try {
            User user = loginService.loginUser(li);
            assertEquals(user.getId(), found.getUser().getId());
        } catch (FailedLoginException e) {
            fail("should have been able to load a user");
        }


    }
}