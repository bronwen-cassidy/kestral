package com.xioq.kestral;

import javax.persistence.*;

/**
 * Users class represents patients
 */
@Entity
@Table(name = "clients")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
}
