package com.xioq.kestral.services.appointments;

import javax.persistence.Column;

/**
 * Time slot for an appointment, not sure this is needed??
 */
public class TimeSlot {

    private String startTime;

    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
