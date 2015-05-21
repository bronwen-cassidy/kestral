package com.xioq.kestral.controller;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.services.AppointmentService;
import com.xioq.kestral.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/client/add", method = RequestMethod.POST,headers = "Accept=application/json")
    public Client addClient(Client client) {
        return clientService.save(client);
    }

}
