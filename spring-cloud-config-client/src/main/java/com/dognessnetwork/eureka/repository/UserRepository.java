package com.dognessnetwork.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dognessnetwork.eureka.domain.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
