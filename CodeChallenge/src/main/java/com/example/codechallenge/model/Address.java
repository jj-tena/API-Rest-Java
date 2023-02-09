package com.example.codechallenge.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String street;

    private String state;

    private String city;

    private String country;

    private String zip;

    public Address(String street, String state, String city, String country, String zip) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public Address() {

    }
}
