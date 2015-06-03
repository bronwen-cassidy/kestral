package com.xioq.kestral.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bronwen.cassidy on 03/06/2015. User is the genereric person who can login,
 * It will either be a client or a provider
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;
    @Column(name = "contact_email")
    protected String contactEmail;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "user_type", nullable = false)
    @Check(constraints = "user_type IN ('P','C')")
    private String userType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;
    @Column(name = "contact_telephone")
    private String contactTelephone;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn (name = "provider_id")
    private List<Appointment> appointments;

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

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (contactEmail != null ? !contactEmail.equals(user.contactEmail) : user.contactEmail != null) return false;
        return !(userType != null ? !userType.equals(user.userType) : user.userType != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("contactEmail", contactEmail)
                .append("firstName", firstName)
                .append("secondName", secondName)
                .append("userType", userType)
                .append("company", company)
                .append("contactTelephone", contactTelephone)
                .toString();
    }
}
