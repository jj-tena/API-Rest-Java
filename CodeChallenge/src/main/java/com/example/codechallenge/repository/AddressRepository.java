package com.example.codechallenge.repository;

import com.example.codechallenge.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
