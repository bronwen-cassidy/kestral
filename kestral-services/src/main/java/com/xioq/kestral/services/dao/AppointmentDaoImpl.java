package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Provider;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by bronwen.cassidy on 13/05/2015.
 * Appointment Dao used to search for speicial searches of appointments
 */
public class AppointmentDaoImpl extends DataAccessorImpl implements AppointmentDao {

    public List<Appointment> find(DateTime start, DateTime end, Provider provider) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createCriteria(Appointment.class)
                .add(Restrictions.eq("provider", provider))
                .add(Restrictions.ge("appointmentDate", start.toDate()))
                .add(Restrictions.le("appointmentDate", end.toDate()));
        return null;
    }
}
