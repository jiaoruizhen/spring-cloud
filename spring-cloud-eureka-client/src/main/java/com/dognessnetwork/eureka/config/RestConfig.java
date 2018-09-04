package com.dognessnetwork.eureka.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate() ;
	}
	
	//定义一个Bean修改头信息进行客户端认证
	@Bean
	public HttpHeaders getHeader() {
	    HttpHeaders headers=new HttpHeaders();
	    String auth="app01:passwd01";//认证的原始信息
	    byte[] encodeAuth=Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));//将原始认证信息进行Base64加密
	    String authHeader="Basic "+new String(encodeAuth);//加密后的认证信息要与Basic有个空格
	    headers.set("Authorization", authHeader);
	    return headers;
	}
}