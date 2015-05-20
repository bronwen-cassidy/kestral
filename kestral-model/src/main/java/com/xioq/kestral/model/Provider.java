package com.xioq.kestral.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bronwen.cassidy on 08/05/2015.
 *
 */
@Entity
@Table (name = "providers")
public class Provider {

    @Id
    @GeneratedValue
    @Column (name="id")
    private Long id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "second_name")
    private String secondName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn (name = "provider_id")
    private List<Appointment> appointments;

    public Provider() {
    }

    public Provider(Long id) {
        this.id = id;
    }

    // todo address
    // todo qualifications
    // todo rates, hourly or salaried should be in a strategy

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider provider = (Provider) o;

        return !(id != null ? !id.equals(provider.id) : provider.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
