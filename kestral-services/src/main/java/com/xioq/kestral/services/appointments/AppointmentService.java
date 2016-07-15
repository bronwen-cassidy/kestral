package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.clients.Client;
import com.xioq.kestral.services.providers.Company;
import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.EntityNotFoundException;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015
 */
@Configuration
public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Appointment> findAll(Provider provider);

    List<Appointment> findAll(Client client);

    Appointment findById(Long id) throws EntityNotFoundException;

    boolean cancelAppointment(Appointment appointment);

    List<Appointment> findAvailableAppointmentSlots(Company company, Provider provider, Date startDate, Date endDate);

    Appointment makeAppointment(Company company, Provider provider, Client client, Date date, String startTime);

    Appointment makeAppointment(Appointment appointment);

    void delete(Long id);
}
