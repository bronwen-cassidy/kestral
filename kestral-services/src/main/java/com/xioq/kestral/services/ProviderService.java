package com.xioq.kestral.services;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.User;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
public interface ProviderService {

    Provider findById(Long id);

    Provider create(Provider provider);

    void update(Provider provider);

    List<Provider> findAll(Long companyId);

    Provider find(User user);
}
