package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import org.joda.time.DateTime;

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
