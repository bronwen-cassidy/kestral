package com.xioq.kestral.services;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Provider;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
public interface ProviderService {

    Provider findById(Long id);
}
