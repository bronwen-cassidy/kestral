package com.xioq.kestral.services.clients;

import com.xioq.kestral.services.providers.Company;
import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.security.User;
import com.xioq.kestral.services.DataAccessorImpl;
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

    public Client find(User user) {
        Session session = sessionFactory.getCurrentSession();
        return (Client) session.createCriteria(Client.class)
                .add(Restrictions.eq("user", user)).uniqueResult();
    }

    public List<Client> findAll(Company company) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Client.class)
                .createCriteria("user").add(Restrictions.eq("company", company)).list();
    }
}
