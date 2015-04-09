package com.xioq.kestral;

import javax.persistence.*;

/**
 * Users class represents patients
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
}
