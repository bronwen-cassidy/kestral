package com.xioq.kestral.services.appointments;

import java.util.List;

/**
 * Class represents a schedule this can be the daily weekly, monthly, yearly or
 * a schedule for any time period for the given country
 * Created by bronwen.cassidy on 13/04/2015.
 */
public class Schedule {

    private List<Appointment> appointments;
    private String startDate;
    private String endDate;

    public Schedule(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
