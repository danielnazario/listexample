package com.example.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.example.entity.User;
import com.example.service.UserService;


import static org.mockito.Mockito.*;

public class UserControllerTest {
	
	private UserService service;
	private List<User> mockList;
	private UserController target;
	        
	@Before
	public void setUp(){
		mockList = (List<User>) mock(List.class);
		service = mock(UserService.class);
		
		when(service.findAll()).thenReturn(mockList);
		
		target = new UserController(service);  	
    }   
	    
	@Test
	public void save(){
		User user = new User();
		
		target.post(user);
		
		verify(service).save(user);
	}
	
	@Test
	public void findAll(){
		List<User> actualList = target.getAll();
		
		Assert.assertEquals(mockList, actualList);
	}

}
