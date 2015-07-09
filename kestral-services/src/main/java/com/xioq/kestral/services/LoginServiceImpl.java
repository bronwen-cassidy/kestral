package com.xioq.kestral.services;

import com.xioq.kestral.model.*;
import com.xioq.kestral.services.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.FailedLoginException;
import java.io.Serializable;

/**
 * Created by bronwen.cassidy on 03/06/2015.
 * The service to manage the login information and validation
 */
@Configuration
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private ClientService clientService;

    public User loginUser(LoginInfo loginInfo) throws FailedLoginException {
        String password = loginInfo.getPassword();
        // todo password encryption, better at db level so it can be decrypted without having to run java code
        LoginInfo validatedLoginInfo = loginDao.findLogin(loginInfo.getUsername(), password);
        // todo loads of login checks to follow in a login validator
        if (validatedLoginInfo == null) {
            throw new InvalidLoginCredentialsException();
        }

        // todo save date logged in (audit info etc to the db)

        return validatedLoginInfo.getUser();
    }

    public LoginInfo addUserLogin(LoginInfo loginInfo) {
        User user = loginInfo.getUser();
        Serializable id = loginDao.save(user);
        user.setId((Long) id);

        loginInfo.setId((Long)id);
        loginInfo.setUser(user);
        loginDao.save(loginInfo);

        String userType = user.getUserType();
        if (User.PROVIDER_TYPE.equals(userType)) {
            Provider provider = new Provider();
            provider.setUser(user);
            providerService.save(provider);
        } else {
            Client client = new Client();
            client.setUser(user);
            clientService.save(client);
        }

        return loginInfo;
    }
}
