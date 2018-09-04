package com.dognessnetwork.eureka.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dognessnetwork.eureka.config.BasicAuthConfiguration;
import com.dognessnetwork.eureka.domain.User;

@FeignClient(name="USER-SERVICE",fallback = UserClientHystrix.class,configuration=BasicAuthConfiguration.class)
public interface UserService {
	
	//必须要添加@RequestParam 注解，否则会报错  Method has too many Body parameters
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public User add(@RequestParam("name") final String name,@RequestParam("age") final String age, @RequestParam("username") final String username);
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<User> findAll();
}
