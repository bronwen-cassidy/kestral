package com.xioq.kestral.model;

import com.sun.javafx.beans.IDProperty;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 15/05/2015.
 * Class that represents a working day for a given business, bank holidays would be excluded
 */
@Entity
@Table (name = "working_days")
public class WorkingDay {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "date")
    private Date daysDate;
    @Column(name = "day")
    private String day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public WorkingDay() {
    }

    public WorkingDay(Long id) {
        this.id = id;
    }

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

    public Date getDaysDate() {
        return daysDate;
    }

    public void setDaysDate(Date daysDate) {
        this.daysDate = daysDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkingDay that = (WorkingDay) o;

        if (daysDate != null ? !daysDate.equals(that.daysDate) : that.daysDate != null) return false;
        return !(company != null ? !company.equals(that.company) : that.company != null);

    }

    @Override
    public int hashCode() {
        int result = daysDate != null ? daysDate.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
