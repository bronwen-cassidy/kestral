package com.xioq.kestral.controller;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.services.AppointmentService;
import com.xioq.kestral.services.DateConstants;
import com.xioq.kestral.services.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value="/appointment/{id}",method = RequestMethod.GET,headers="Accept=application/json")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @RequestMapping(value="/appointment/delete/{id}",method = RequestMethod.GET,headers="Accept=application/json")
    public String deleteAppointment(@PathVariable Long id) {

        try {
            appointmentService.delete(id);
        } catch (EntityNotFoundException e) {
            return Constants.ERROR;
        }
        return Constants.SUCCESS;
    }

    @RequestMapping(value="/appointment/c/{id}",method = RequestMethod.GET,headers="Accept=application/json")
    public List<Appointment> findCompanyAppointments(@PathVariable Long id) {
        return appointmentService.findAll(new Company(id));
    }

    @RequestMapping(value="/appointment/p/{id}",method = RequestMethod.GET,headers="Accept=application/json")
    public List<Appointment> findProviderAppointments(@PathVariable Long id) {
        return appointmentService.findAll(new Provider(id));
    }

    @RequestMapping(value="/appointment/cl/{id}",method = RequestMethod.GET,headers="Accept=application/json")
    public List<Appointment> findClientAppointments(@PathVariable Long id) {
        return appointmentService.findAll(new Client(id));
    }

    @RequestMapping(value="/appointment/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.makeAppointment(appointment);
    }

    @RequestMapping(value="/appointment/make/{companyId}/p/{providerId}/c/{clientId}/{startDate}/{startTime}",method = RequestMethod.GET,headers="Accept=application/json")
    public Appointment makeAppointment(@PathVariable Long companyId, @PathVariable Long providerId, @PathVariable Long clientId, @PathVariable String startDate, @PathVariable String startTime) {
        Date start = DateConstants.DATE_TIME_FORMATTER.parseDateTime(startDate).toDate();
        return appointmentService.makeAppointment(new Company(companyId), new Provider(providerId), new Client(clientId), start, startTime);
    }

}
