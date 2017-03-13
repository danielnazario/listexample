package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void post(@RequestBody User user) {
        repository.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public List<User> getAllByName(@PathVariable String name) {
        return repository.findByName(name);
    }
}
