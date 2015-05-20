package com.xioq.kestral.controller;

import com.xioq.kestral.model.Provider;
import com.xioq.kestral.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping(value="/provider/add", method = RequestMethod.POST,headers="Accept=application/json")
    public Provider addProvider(@RequestBody Provider provider) {
        return providerService.create(provider);
    }

    @RequestMapping(value="/provider/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public Provider getProvider(@PathVariable Long id) {
        return providerService.findById(id);
    }

}
