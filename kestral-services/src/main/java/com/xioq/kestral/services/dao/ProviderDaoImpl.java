package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by bronwen.cassidy on 15/06/2015
 */
@Repository(value = "providerDao")
public class ProviderDaoImpl extends DataAccessorImpl implements ProviderDao {

    public Provider find(User user) {
        Session session = sessionFactory.getCurrentSession();
        return (Provider) session.createCriteria(Provider.class)
                .add(Restrictions.eq("user", user)).uniqueResult();
    }
}