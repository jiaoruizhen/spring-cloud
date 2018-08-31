package com.dognessnetwork.eureka.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dognessnetwork.eureka.domain.User;

@FeignClient(name="USER-SERVICE")
public interface UserService {
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public User add(User user);
	
	@RequestMapping(value="/findAll",method=RequestMethod.POST)
	public List<User> findAll();
}
