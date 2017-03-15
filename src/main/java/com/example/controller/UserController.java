package com.example.controller;


import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService service){
		this.userService = service;
	}

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void post(@RequestBody User user) {
    	userService.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public List<User> getAllByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
