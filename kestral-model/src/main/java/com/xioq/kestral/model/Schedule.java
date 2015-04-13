package com.xioq.kestral.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Class represents a schedule this can be the daily weekly, monthly, yearly or
 * a schedule for any time period for the given country
 * Created by bronwen.cassidy on 13/04/2015.
 */
@Entity
@Table
public class Schedule {

    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
