package com.dognessnetwork.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
	@Value("${version}")
	String version;
	
	@Value("${name}")
	String name;
	
	@Value("${age}")
	String age;
	
	@RequestMapping(value="/getVersion")
	public String getVersion(){
		return this.version;
	}
	
	@RequestMapping("/test")
	public String hello(){
		return "hello world!";
	}
	
	@RequestMapping("/getUser")
	public String getUser(){
		return this.name+","+this.age;
	}
}
