package com.dognessnetwork.eureka.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dognessnetwork.eureka.domain.User;
import com.dognessnetwork.eureka.repository.UserRepository;
import com.dognessnetwork.eureka.service.UserService;

@Service
public class UserServiceImpl implements UserService{
		
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User add(String name, String age, String username) {
		User user=new User();
		user.setAge(Integer.parseInt(age));
		user.setName(name);
		user.setUsername(username);
		
		return userRepository.save(user);
	}

}
