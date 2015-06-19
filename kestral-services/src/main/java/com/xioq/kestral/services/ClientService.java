package com.xioq.kestral.services;

import com.xioq.kestral.model.*;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.FailedLoginException;
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
}
