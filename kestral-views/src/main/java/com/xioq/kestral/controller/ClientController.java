package com.xioq.kestral.controller;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.services.AppointmentService;
import com.xioq.kestral.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("add")
    public Appointment makeAppointment() {
        return null;
    }

}
