package com.xioq.kestral.services;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.User;
import com.xioq.kestral.services.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015
 */
@Configuration
@Service ("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private UserService userService;

    public Client findById(Long id) throws EntityNotFoundException {
        return clientDao.findById(id, Client.class);
    }

    public Client save(Client client) {

        User user = userService.save(client.getUser());
        client.setUser(user);

        Long id = (Long) clientDao.save(client);
        client.setId(id);
        return client;
    }

    public List<Client> findAllForProvider(Long providerId) {
        return clientDao.findForProvider(new Provider(providerId));
    }

    public Client find(User user) {
        return clientDao.find(user);
    }

    public void delete(Long id) {
        Client client = findById(id);
        clientDao.delete(client);
    }

    public void update(Client expected) {
        clientDao.saveOrUpdate(expected);
    }

    public List<Client> findAll(Long companyId) {
        return clientDao.findAll(new Company(companyId));
    }
}
