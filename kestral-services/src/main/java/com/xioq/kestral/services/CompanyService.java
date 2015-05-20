package com.xioq.kestral.services;

import com.xioq.kestral.model.Company;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 *
 */
@Configuration
public interface CompanyService {

    Company findById(Long id);

    Company create(Company company);

    void update(Company company);
}
