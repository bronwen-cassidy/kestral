package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Provider;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by bronwen.cassidy on 13/05/2015.
 */
public interface AppointmentDao extends DataAccessor {

    List<Appointment> find(DateTime start, DateTime end, Provider provider);
}
