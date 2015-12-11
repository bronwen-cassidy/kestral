package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.clients.Client;
import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.DataAccessor;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 13/05/2015
 */
public interface AppointmentDao extends DataAccessor {

    List<Appointment> find(Provider provider, Date start, Date end);

    List<Appointment> findAll(Provider provider);

    List<Appointment> findAll(Client client);

    List<Appointment> find(Client client, Date start, Date end);
}
