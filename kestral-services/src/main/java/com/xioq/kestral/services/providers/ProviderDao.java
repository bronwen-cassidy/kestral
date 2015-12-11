package com.xioq.kestral.services.providers;

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
public interface ProviderDao extends DataAccessor {
    Provider find(User user);

    List<Provider> findAll(Company company);
}
