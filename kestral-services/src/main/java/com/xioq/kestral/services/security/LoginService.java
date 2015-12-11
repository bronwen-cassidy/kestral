package com.xioq.kestral.services.security;

import javax.security.auth.login.FailedLoginException;

/**
 * Created by bronwen.cassidy on 03/06/2015
 */
public interface LoginService {

    User loginUser(LoginInfo loginInfo) throws FailedLoginException;

    LoginInfo addUserLogin(LoginInfo loginInfo);
}
