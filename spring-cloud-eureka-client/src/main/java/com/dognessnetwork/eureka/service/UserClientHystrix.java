
package com.dognessnetwork.eureka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dognessnetwork.eureka.domain.User;

@Service
public class UserClientHystrix implements UserService {
 
	@Override
	public User add(String name,String age,String username) {
		// TODO Auto-generated method stub
		 throw new NullPointerException(" User add() 服务不可用。。");
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		 throw new NullPointerException(" List<User> findAll() 服务不可用。。");
	}
 
}