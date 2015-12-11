package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.clients.Client;
import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.DataAccessorImpl;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 13/05/2015.
 * Appointment Dao used to search for speicial searches of appointments
 */
@Repository( "appointmentDao" )
public class AppointmentDaoImpl extends DataAccessorImpl implements AppointmentDao {

    public List<Appointment> find(Provider provider, Date start, Date end) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createCriteria(Appointment.class)
                .add(Restrictions.eq("provider", provider))
                .add(Restrictions.ge("appointmentDate", start))
                .add(Restrictions.le("appointmentDate", end))
                .addOrder(Order.desc("appointmentDate")).addOrder(Order.asc("startTime"))
                .list();
    }

    public List<Appointment> findAll(Provider provider) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createCriteria(Appointment.class)
                .add(Restrictions.eq("provider", provider))
                .addOrder(Order.desc("appointmentDate")).addOrder(Order.desc("startTime"))
                .list();
    }

    public List<Appointment> findAll(Client client) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createCriteria(Appointment.class)
                .add(Restrictions.eq("client", client))
                .addOrder(Order.desc("appointmentDate")).addOrder(Order.desc("startTime"))
                .list();
    }

    public List<Appointment> find(Client client, Date start, Date end) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createCriteria(Appointment.class)
                .add(Restrictions.eq("client", client))
                .add(Restrictions.ge("appointmentDate", start))
                .add(Restrictions.le("appointmentDate", end))
                .addOrder(Order.desc("appointmentDate")).addOrder(Order.desc("startTime"))
                .list();
    }
}
