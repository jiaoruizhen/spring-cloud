package com.dognessnetwork.eureka.service;

import java.util.List;

import com.dognessnetwork.eureka.domain.User;

public interface UserService {
	
	List<User> selectAll();

	User add(String name, String age, String username);
}
