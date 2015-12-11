package com.xioq.kestral.services.providers;

import com.xioq.kestral.services.appointments.Appointment;
import com.xioq.kestral.services.security.User;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    @BatchSize(size = 30)
    private Set<Appointment> appointments = new LinkedHashSet<Appointment>();

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

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
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
