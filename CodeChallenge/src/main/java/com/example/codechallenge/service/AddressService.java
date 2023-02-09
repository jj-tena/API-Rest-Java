package com.example.codechallenge.service;

import com.example.codechallenge.model.Address;
import com.example.codechallenge.repository.AddressRepository;
import org.springframework.stereotype.Component;

@Component
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public void save(Address address){
        this.addressRepository.save(address);
    }
}
