package com.example.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.entity.User;
import com.example.repository.UserRepository;


import static org.mockito.Mockito.*;

public class UserServiceTest {
	
	private static final User USER = new User();
	private List<User> mockList;
	private UserService target;
	private UserRepository userRepository;

	@Before
	public void setup(){
		List<User> mock = mock(List.class);
		mockList = mock;
		
		userRepository = mock(UserRepository.class);
		when(userRepository.findAll()).thenReturn(mockList);
		
		target = new UserService(userRepository);
	}
	
	@Test
	public void saveUser(){
		target.save(USER);

		verify(userRepository).save(USER);
	}
	
	@Test
	public void findAllUsers(){
		List<User> users = target.findAll();

		Assert.assertEquals(mockList, users);		
	}

}
