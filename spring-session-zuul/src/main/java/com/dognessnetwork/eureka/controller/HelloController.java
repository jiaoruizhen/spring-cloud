package com.dognessnetwork.eureka.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController{
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public Object hello(HttpSession session,HttpServletResponse response){
		String id=session.getId();
		response.addHeader("x-auth-token", id);
		return id;
	}
}
