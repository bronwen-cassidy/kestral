package com.xioq.kestral.services;

import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.services.dao.DataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 *
 */
@Configuration
@Service ("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private DataAccessor dataAccessor;

    public Provider findById(Long id) {
        return dataAccessor.findById(id, Provider.class);
    }

    @Transactional(readOnly = false)
    public Provider create(Provider provider) {
        Serializable id = dataAccessor.save(provider);
        provider.setId((Long)id);
        return provider;
    }

    @Transactional(readOnly = false)
    public void update(Provider provider) {
        dataAccessor.saveOrUpdate(provider);
    }

    public List<Provider> findAll(Long companyId) {
        return dataAccessor.findAll(Provider.class, new Company(companyId));
    }
}
