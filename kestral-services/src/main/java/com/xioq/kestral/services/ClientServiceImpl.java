package com.xioq.kestral.services;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.services.dao.DataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
@Service ("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private DataAccessor dataAccessor;

    public Client findById(Long id) {
        return dataAccessor.findById(id, Client.class);
    }
}
