package com.xioq.kestral.model;

import javax.persistence.*;

/**
 * Class represents a company, this is a multi-tenant system where each company will have
 * it's own schedules and appointment systems
 * Created by bronwen.cassidy on 13/04/2015.
 */
@Entity
@Table (name = "companies")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    public Company() {
    }

    public Company(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
