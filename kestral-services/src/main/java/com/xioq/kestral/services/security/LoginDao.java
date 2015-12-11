package com.xioq.kestral.services.security;

import com.xioq.kestral.services.DataAccessor;

/**
 * Created by bronwen.cassidy on 13/05/2015.
 */
public interface LoginDao extends DataAccessor {

    LoginInfo findLogin(String username, String password);
}
