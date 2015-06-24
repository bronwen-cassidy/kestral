package com.xioq.kestral.services;

import com.xioq.kestral.model.InvalidLoginCredentialsException;
import com.xioq.kestral.model.LoginInfo;
import com.xioq.kestral.model.User;

import javax.security.auth.login.FailedLoginException;

/**
 * Created by bronwen.cassidy on 03/06/2015
 */
public interface LoginService {

    User loginUser(LoginInfo loginInfo) throws FailedLoginException;

}
