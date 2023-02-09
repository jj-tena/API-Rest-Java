package com.example.codechallenge.controller;

import com.example.codechallenge.model.User;
import com.example.codechallenge.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public void save(User user){
        userService.save(user);
    }

    //This method return a collection with every user stored in the system
    @GetMapping("/getusers")
    public ResponseEntity<Collection<User>> getUsers(){
        Collection<User> userList = userService.findAll();
        if (!userList.isEmpty())
            return ResponseEntity.ok(userList);
        else
            return ResponseEntity.notFound().build();
    }

    //This method return the user whose id matches with userId parameter
    @GetMapping("/getusersById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId){
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent())
            return ResponseEntity.ok(userOptional.get());
        else
            return ResponseEntity.notFound().build();
    }

    //This method create an user in the system based on the information of the request body
    @PostMapping("/createUsers")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userService.save(user);
        Optional<User> userOptional = userService.findById(user.getId());
        if (userOptional.isPresent())
            return ResponseEntity.ok(userOptional.get());
        else
            return ResponseEntity.notFound().build();
    }

    //This method deletes the user whose id matches with userId parameter
    @DeleteMapping("/deleteUsersById/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable Integer userId){
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent()) {
            userService.deleteById(userId);
            return ResponseEntity.ok(userOptional.get());
        }
        else
            return ResponseEntity.notFound().build();
    }

    //This method updates the user whose id matches with userId parameter, the new information of the user will be based on the request body
    @PutMapping("/updateUsersById/{userId}")
    public ResponseEntity<User> putUser(@PathVariable Integer userId, @RequestBody User user){
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent()){
            userService.updateById(userOptional.get(), user);
            return ResponseEntity.ok(userOptional.get());
        }
        else
            return ResponseEntity.notFound().build();
    }

}
