package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private UserRepository repository;
	
	@Autowired 
	public UserService(UserRepository repository){
		this.repository = repository;
	}
	
	public void save(User user){
		repository.save(user);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public List<User> findByName(String name){
		return repository.findByName(name);
	}
	
	
}
