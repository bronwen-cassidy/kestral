package com.xioq.kestral.model;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn (name = "provider_id")
    private List<Appointment> appointments;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Provider() {
    }

    public Provider(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
