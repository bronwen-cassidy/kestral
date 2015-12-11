package com.xioq.kestral.services.clients;

import com.xioq.kestral.services.providers.Company;
import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.security.User;
import com.xioq.kestral.services.DataAccessor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bronwen.cassidy on 15/04/2015.
 * Geberic data accessor that will connect to the database and implement the findById save and load
 * db methods
 */
@Repository
public interface ClientDao extends DataAccessor {
    List<Client> findForProvider(Provider provider);

    Client find(User user);

    List<Client> findAll(Company company);
    // todo a generic search method??
}
