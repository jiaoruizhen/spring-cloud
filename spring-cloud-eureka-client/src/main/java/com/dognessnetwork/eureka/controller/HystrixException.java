package com.dognessnetwork.eureka.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RestController;

import com.dognessnetwork.eureka.domain.User;
import com.dognessnetwork.eureka.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixException {

	
	    @Resource
	    private UserService userService;
	    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
	    @HystrixCommand(fallbackMethod="getFallback")    // 如果当前调用的get()方法出现了错误，则执行fallback
	    public Object findAll() {
	    	List<User> users=userService.findAll();
	        if (users.size()<=0) {    // 数据不存在，假设让它抛出个错误
	            throw new RuntimeException("部门信息不存在！") ;
	        }
	        return users ;
	    }
	    public Object getFallback() {    // 此时方法的参数 与get()一致
	        return "【ERROR】Microcloud-Dept-Hystrix" ;
	    }
	    
	    
	
}
