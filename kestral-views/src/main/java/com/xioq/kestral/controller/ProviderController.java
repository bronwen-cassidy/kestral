package com.xioq.kestral.controller;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.services.AppointmentService;
import com.xioq.kestral.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/provider/add")
    public Provider addProvider(@RequestBody Provider provider) {
        return providerService.create(provider);
    }

}
