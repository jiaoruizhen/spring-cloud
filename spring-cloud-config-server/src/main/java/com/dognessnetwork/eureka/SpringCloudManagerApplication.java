package com.dognessnetwork.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudManagerApplication.class, args);
	}
}
