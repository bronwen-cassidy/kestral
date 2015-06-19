package com.xioq.kestral.services;

import com.xioq.kestral.model.*;
import com.xioq.kestral.services.dao.AppointmentDao;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 * Appointment service to handle all making, cancelling and updating of an appointment
 */
@Configuration
@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    public static final int COMPANY_SPECIFIC_TIME_SLOT_CONFIGURATION = 60;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private WorkingDayService workingDayService;

    public List<Appointment> findAll(Company company) {
        return appointmentDao.findAll(Appointment.class, company);
    }

    public Appointment save(Appointment appointment) {
        if (appointment.getId() == null) {
            Serializable id = appointmentDao.save(appointment);
            appointment.setId((Long) id);
        } else {
            appointmentDao.saveOrUpdate(appointment);
        }
        return appointment;
    }

    public List<Appointment> findAll(Provider provider) {
        return appointmentDao.findAll(provider);
    }

    public List<Appointment> findAll(Client client) {
        return appointmentDao.findAll(client);
    }

    public Appointment findById(Long id) throws EntityNotFoundException {
        return appointmentDao.findById(id, Appointment.class);
    }

    public Appointment makeAppointment(Company company, Provider provider, Client client, Date date, String startTime) {
        List<Appointment> availableAppointments = findAvailableAppointments(company, provider, date, date);
        for (Appointment availableAppointment : availableAppointments) {
            if(availableAppointment.getStartTime().equals(startTime)) {
                LocalTime tme = DateConstants.TIME_FORMATTER.parseLocalTime(startTime);
                Appointment available = new Appointment();
                available.setStartTime(startTime);
                available.setEndTime(tme.plusMinutes(COMPANY_SPECIFIC_TIME_SLOT_CONFIGURATION).toString());
                available.setAppointmentDate(date);
                available.setProvider(provider);
                available.setCompany(company);
                available.setClient(client);
                save(available);
                return available;
            }
        }
        return null;
    }

    public void delete(Long id) {
        Appointment appointment = findById(id);
        appointmentDao.delete(appointment);
    }

    public Appointment makeAppointment(Appointment appointment) {
        return save(appointment);
    }

    public List<Appointment> findAvailableAppointments(Company company, Provider provider, Date startDate, Date endDate) {
        // get the list of all possible time periods (30 mins for now) per day for each day in the interim period
        List<Appointment> occupiedAppointments = new ArrayList<Appointment>(appointmentDao.find(provider, startDate, endDate));

        List<WorkingDay> workingDays = workingDayService.find(company, startDate, endDate);
        List<Appointment> availableAppointments = new ArrayList<Appointment>();
        for (WorkingDay workingDay : workingDays) {
            // for each day and each time slot findById a corresponding appointment time of make a new one

            // todo remove breaks periods?? put into configuration
            LocalTime tme = DateConstants.TIME_FORMATTER.parseLocalTime(workingDay.getStartTime());
            LocalTime endOfTheDay = DateConstants.TIME_FORMATTER.parseLocalTime(workingDay.getEndTime());
            LocalTime nextTime = tme;
            while (nextTime.isBefore(endOfTheDay)) {
                // FIND AN APPOINTMENT starting at this time remove as you findById
                String startTime = DateConstants.TIME_FORMATTER.print(nextTime);
                boolean found = filterAppointments(occupiedAppointments, workingDay.getDaysDate(), startTime);
                if(!found) {
                    Appointment available = new Appointment();
                    available.setStartTime(startTime);
                    available.setEndTime(tme.plusMinutes(COMPANY_SPECIFIC_TIME_SLOT_CONFIGURATION).toString());
                    available.setAppointmentDate(workingDay.getDaysDate());
                    available.setProvider(provider);
                    available.setCompany(company);
                    availableAppointments.add(available);
                }
                nextTime = nextTime.plusMinutes(COMPANY_SPECIFIC_TIME_SLOT_CONFIGURATION);
            }
        }

        return availableAppointments;
    }

    private boolean filterAppointments(List<Appointment> occupiedAppointments, Date daysDate, String startTime) {
        for (Iterator<Appointment> iterator = occupiedAppointments.iterator(); iterator.hasNext(); ) {
            Appointment next = iterator.next();

            if(next.getAppointmentDate().equals(daysDate) && next.getStartTime().equals(startTime)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean cancelAppointment(Appointment appointment) {
        try {
            // can apply a lot of logic here, conditions, fees etc
            appointmentDao.delete(appointment);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
