package com.dognessnetwork.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dognessnetwork.eureka.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Object add(String name,String age,String username){
		return userService.add(name,age,username);
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.POST)
	public Object findAll(){
		return userService.findAll();
	}
}
