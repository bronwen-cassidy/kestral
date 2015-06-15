package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Provider;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bronwen.cassidy on 15/06/2015
 */
@Repository (value = "clientDao")
public class ClientDaoImpl extends DataAccessorImpl implements ClientDao {

    public List<Client> findForProvider(Provider provider) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Client.class)
                .add(Restrictions.eq("provider", provider)).list();
    }
}
