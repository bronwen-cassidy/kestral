package com.xioq.kestral.controller;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.services.AppointmentService;
import com.xioq.kestral.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value="/company/add", method = RequestMethod.POST,headers="Accept=application/json")
    public Company createCompany(@RequestBody Company company) {
        return companyService.create(company);
    }

    @RequestMapping(value="/company/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public Company getCompany(@PathVariable Long id) {
        return companyService.findById(id);
    }
}
