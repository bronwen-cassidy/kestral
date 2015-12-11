package com.xioq.kestral.services.security;

import com.xioq.kestral.services.DataAccessorImpl;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by bronwen.cassidy on 03/06/2015
 */
@Repository("loginDao")
public class LoginDaoImpl extends DataAccessorImpl implements LoginDao {

    public LoginInfo findLogin(String username, String password) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (LoginInfo) currentSession.createCriteria(LoginInfo.class)
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password)).uniqueResult();
    }
}
