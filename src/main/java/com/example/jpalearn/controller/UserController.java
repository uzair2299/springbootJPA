package com.example.jpalearn.controller;

import com.example.jpalearn.Entity.User;
import com.example.jpalearn.exceptions.UserNotFoundException;
import com.example.jpalearn.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController


public class UserController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET,path = "/users",params = "!v")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,path = "v1/users")
    public String getAllUsersV1(){
        return "return all user list with v1/users";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/users",params = "v=1")
    public String getAllUsersParamV1(){
        return "return all user list with v=1";
    }



    @RequestMapping(method = RequestMethod.GET,path = "/users/{id}")
    public User getUserById(@PathVariable Long id){
        User byId = userRepository.findById(id);
        if(byId==null){
            throw new UserNotFoundException("id"+ id);
        }
        return byId;
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser =  userRepository.save(user);
        //URI location = URI.create("/users/" + savedUser.getId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).body(savedUser);
    }
}
