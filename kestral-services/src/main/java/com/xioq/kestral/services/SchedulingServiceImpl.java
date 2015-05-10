package com.xioq.kestral.services;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Schedule;
import com.xioq.kestral.services.dao.DataAccessor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private DataAccessor dataAccessor;

    public Schedule findTodaysSchedule(Company company) {

        // utc date
        DateTime current = new DateTime();
        String today = current.toString(DateConstants.UTC_DATE_FORMAT);
        Schedule schedule = new Schedule(today, today);
        List<Appointment> appointments = dataAccessor.findAll(Appointment.class);
        schedule.setAppointments(appointments);
        return schedule;
    }
}
