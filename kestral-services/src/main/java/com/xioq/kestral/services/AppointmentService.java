package com.xioq.kestral.services;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
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

    Appointment findById(Long id);

    boolean cancelAppointment(Appointment appointment);

    List<Appointment> findAvailableAppointments(Company company, Provider provider, Date startDate, Date endDate);

    Appointment makeAppointment(Company company, Provider provider, Client client, Date date, String startTime);

    Appointment makeAppointment(Appointment appointment);
}
