package com.xioq.kestral.services;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 */
@Configuration
public interface AppointmentService {

    List<Appointment> findAll(Company company);

    Appointment save(Appointment appointment);

    List<Appointment> findAll(Provider provider);

    List<Appointment> findAll(Client client);
}
