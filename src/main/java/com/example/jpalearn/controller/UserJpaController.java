package com.example.jpalearn.controller;

import com.example.jpalearn.Entity.User;
import com.example.jpalearn.exceptions.UserNotFoundException;
import com.example.jpalearn.repository.UserJPARepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController


public class UserJpaController {


    @Autowired
    UserJPARepository userRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/jpa/users", params = "!v")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //api versioning with path parameter
    @RequestMapping(method = RequestMethod.GET, path = "/jpa/v1/users")
    public String getAllUsersV1() {
        return "return all user list with v1/users";
    }

    //api versioning with Query parameter
    @RequestMapping(method = RequestMethod.GET, path = "/jpa/users", params = "v=1")
    public String getAllUsersParamV1() {
        return "return all user list with v=1";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/jpa/users/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new UserNotFoundException("not found id -" + id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/jpa/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/jpa/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        //URI location = URI.create("/users/" + savedUser.getId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/jpa/usersDynamicFiltering")
    public ResponseEntity<MappingJacksonValue> getAllUsersWithDynamicFiltering() {
        //determine whether include or exclude
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .serializeAllExcept("email");

        //link the login and filter name
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("userFilter", filter);
        List<User> users = userRepository.findAll();
        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);
        return ResponseEntity.ok(mapping);
    }

}
