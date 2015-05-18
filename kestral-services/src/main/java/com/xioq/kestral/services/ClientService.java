package com.xioq.kestral.services;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
public interface ClientService {

    Client findById(Long id);

    Client save(Client client);

    void update(Client expected);
}
