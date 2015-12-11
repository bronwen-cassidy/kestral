package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.DateConstants;
import com.xioq.kestral.services.clients.Client;
import com.xioq.kestral.services.providers.Provider;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 13/04/2015.
 * Implementation for the schedule
 */
@Configuration
@Service( "schedulingService" )
@Transactional
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private AppointmentDao appointmentDao;

    public Schedule findTodaysSchedule(Provider provider) {

        // utc date
        DateTime current = new DateTime();
        String today = current.toString(DateConstants.UTC_DATE_FORMAT);
        Schedule schedule = new Schedule(today, today);

        List<Appointment> appointments = appointmentDao.findAll(provider);
        schedule.setAppointments(appointments);
        return schedule;
    }

    @Transactional (readOnly = true)
    public Schedule find(Provider provider, Date start, Date end) {
        Schedule schedule = new Schedule(start.toString(), end.toString());
        List<Appointment> appointments = appointmentDao.find(provider, start, end);
        schedule.setAppointments(appointments);
        return schedule;
    }

    public Schedule find(Client client, Date start, Date end) {
        Schedule schedule = new Schedule(start.toString(), end.toString());
        List<Appointment> appointments = appointmentDao.find(client, start, end);
        schedule.setAppointments(appointments);
        return schedule;
    }
}
