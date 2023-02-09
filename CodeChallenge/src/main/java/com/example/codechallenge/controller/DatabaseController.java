package com.example.codechallenge.controller;

import com.example.codechallenge.model.Address;
import com.example.codechallenge.model.User;
import com.example.codechallenge.service.AddressService;
import com.example.codechallenge.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class DatabaseController {

    private final AddressService addressService;

    private final UserService userService;

    public DatabaseController(AddressService addressService, UserService userService){
        this.addressService = addressService;
        this.userService = userService;
    }

    @PostConstruct
    public void initialiseDatabase(){

        Address address1 = new Address("Street1", "State1", "City1", "Country1", "Zip1");
        Address address2 = new Address("Street2", "State1", "City2", "Country2", "Zip2");

        addressService.save(address1);
        addressService.save(address2);

        Date date1 = new Date();
        Date date2 = new Date();

        User user1 = new User("Name1", "Email1@email.com", date1, address1);
        User user2 = new User("Name2", "Email2@email.com", date2, address2);

        userService.save(user1);
        userService.save(user2);

    }

}