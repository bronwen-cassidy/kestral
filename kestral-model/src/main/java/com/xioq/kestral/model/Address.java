package com.xioq.kestral.model;

import javax.persistence.*;

/**
 * Created by bronwen.cassidy on 18/05/2015.
 */
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    @Column(name="house_number")
    private String houseNumber;
    @Column(name="street")
    private String street;
    @Column(name="post_code")
    private String postCode;
    @Column(name="country")
    private String country;
    @Column(name="town")
    private String town;
    @Column(name="county")
    private String county;

    public Address() {
    }

    public Address(String houseNumber, String street, String postCode, String country, String town, String county) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.postCode = postCode;
        this.country = country;
        this.town = town;
        this.county = county;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
