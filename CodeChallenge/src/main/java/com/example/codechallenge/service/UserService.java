package com.example.codechallenge.service;

import com.example.codechallenge.model.Address;
import com.example.codechallenge.model.User;
import com.example.codechallenge.repository.AddressRepository;
import com.example.codechallenge.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void save(User user){
        this.userRepository.save(user);
    }

    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer userId){
        return userRepository.findById(userId);
    }

    public void deleteById(Integer userId){
        userRepository.deleteById(userId);
    }

    public void updateById(User oldUser, User updatedUser){
        oldUser.setAddress(updatedUser.getAddress());
        oldUser.setBirthDate(updatedUser.getBirthDate());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setName(updatedUser.getName());
        userRepository.save(oldUser);
    }
}
