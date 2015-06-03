package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.LoginInfo;
import com.xioq.kestral.model.Provider;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 13/05/2015.
 */
public interface LoginDao extends DataAccessor {

    LoginInfo findLogin(String username, String password);
}
