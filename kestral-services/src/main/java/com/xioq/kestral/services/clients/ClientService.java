package com.xioq.kestral.services.clients;

import com.xioq.kestral.services.EntityNotFoundException;
import com.xioq.kestral.services.security.User;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015
 */
@Configuration
public interface ClientService {

    Client findById(Long id) throws EntityNotFoundException;

    Client save(Client client);

    void update(Client expected);

    List<Client> findAllForProvider(Long providerId);

    Client find(User user);

    void delete(Long id);

    List<Client> findAll(Long companyId);
}
