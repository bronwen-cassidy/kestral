package com.xioq.kestral.services;

import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.LoginInfo;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.User;
import com.xioq.kestral.services.dao.ProviderDao;
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
    private ProviderDao providerDao;
    @Autowired
    private LoginService loginService;

    public Provider findById(Long id) throws EntityNotFoundException {
        return providerDao.findById(id, Provider.class);
    }

    @Transactional(readOnly = false)
    public Provider save(Provider provider) {
        // save the user first then the loginInfo then the provider
        Serializable id = providerDao.save(provider);
        provider.setId((Long)id);
        return provider;
    }

    @Transactional(readOnly = false)
    public void update(Provider provider) {
        providerDao.saveOrUpdate(provider);
    }

    public List<Provider> findAll(Long companyId) {
        return providerDao.findAll(new Company(companyId));
    }

    public Provider find(User user) {
        return providerDao.find(user);
    }

    public void delete(Long id) {
        Provider provider = findById(id);
        providerDao.delete(provider);
    }
}
