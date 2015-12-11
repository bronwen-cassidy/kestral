package com.xioq.kestral.controller;

import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.security.LoginService;
import com.xioq.kestral.services.providers.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/provider/add", method = RequestMethod.POST,headers="Accept=application/json")
    public Provider addProvider(@RequestBody Provider provider) {
        return providerService.save(provider);
    }

    @RequestMapping(value="/provider/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public Provider getProvider(@PathVariable Long id) {
        Provider provider = providerService.findById(id);
        return provider != null ? provider : new Provider();
    }

    @RequestMapping(value="/provider/delete/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public String deleteProvider(@PathVariable Long id) {
        try {
            providerService.delete(id);
        } catch (Exception e) {
            return Constants.ERROR;
        }
        return Constants.SUCCESS;
    }

    @RequestMapping(value="/all/{companyId}", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Provider> getAllProviders(@PathVariable Long companyId) {
        return providerService.findAll(companyId);
    }
}
