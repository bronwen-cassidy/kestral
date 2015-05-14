package com.xioq.kestral.services;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.services.dao.AppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
@Service( "appointmentService" )
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao dataAccessor;

    public List<Appointment> findAll(Company company) {
        return dataAccessor.findAll(Appointment.class, company);
    }

    public Appointment save(Appointment appointment) {
        Serializable id = dataAccessor.save(appointment);
        appointment.setId((Long)id);
        return appointment;
    }

    public List<Appointment> findAll(Provider provider) {
        return dataAccessor.findAll(provider);
    }

    public List<Appointment> findAll(Client client) {
        return dataAccessor.findAll(client);
    }
}
