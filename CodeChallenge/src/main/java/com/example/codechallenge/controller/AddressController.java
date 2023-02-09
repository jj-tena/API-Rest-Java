package com.example.codechallenge.controller;

import com.example.codechallenge.model.Address;
import com.example.codechallenge.model.User;
import com.example.codechallenge.service.AddressService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    public void save(Address address){
        addressService.save(address);
    }
}
