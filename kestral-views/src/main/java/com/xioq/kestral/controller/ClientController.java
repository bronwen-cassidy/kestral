package com.xioq.kestral.controller;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET,headers = "Accept=application/json")
    public Client getClient(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "/client/delete/{id}", method = RequestMethod.GET,headers = "Accept=application/json")
    public String deleteClient(@PathVariable Long id) {
        try {
            clientService.delete(id);
        } catch (Exception e) {
            return Constants.ERROR;
        }
        return Constants.SUCCESS;
    }

    @RequestMapping(value = "/{providerId}", method = RequestMethod.GET,headers = "Accept=application/json")
    public List<Client> getClients(@PathVariable Long providerId) {
        return clientService.findAllForProvider(providerId);
    }

    @RequestMapping(value = "/client/search/forcompany/{companyId}", method = RequestMethod.GET,headers = "Accept=application/json")
    public List<Client> findAllClients(@PathVariable Long companyId) {
        return clientService.findAll(companyId);
    }

    @RequestMapping(value = "/client/add", method = RequestMethod.POST,headers = "Accept=application/json")
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }
}
