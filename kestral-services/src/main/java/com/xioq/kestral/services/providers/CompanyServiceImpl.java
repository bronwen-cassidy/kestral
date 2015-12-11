package com.xioq.kestral.services.providers;

import com.xioq.kestral.services.DataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by bronwen.cassidy on 20/05/2015.
 *
 */
@Configuration
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private DataAccessor dataAccessor;

    public Company findById(Long id) {
        return dataAccessor.findById(id, Company.class);
    }

    @Transactional(readOnly = false)
    public Company create(Company company) {
        Serializable id = dataAccessor.save(company);
        company.setId((Long)id);
        return company;
    }

    @Transactional(readOnly = false)
    public void update(Company company) {
        dataAccessor.saveOrUpdate(company);
    }
}
