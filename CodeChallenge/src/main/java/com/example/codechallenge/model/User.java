package com.example.codechallenge.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private Date birthDate;

    @OneToOne
    private Address address;

    public User(String name, String email, Date birthDate, Address address) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
    }

    public User(){}
}
