package com.xioq.kestral.services;

import com.xioq.kestral.model.Provider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
@Service ("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {
    public Provider findById(Long id) {
        return null;
    }
}
