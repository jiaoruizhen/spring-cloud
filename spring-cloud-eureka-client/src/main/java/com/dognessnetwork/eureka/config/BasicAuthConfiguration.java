package com.dognessnetwork.eureka.config;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.annotation.Bean;


import feign.auth.BasicAuthRequestInterceptor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class BasicAuthConfiguration extends FeignContext{
	private String username;
	private String password;
	public static final String TOKEN_HEADER_PARAM = "X-Authorization";
	
	public void getUserInfo(HttpServletRequest request){
		String token=request.getHeader(TOKEN_HEADER_PARAM);
		if(StringUtils.isEmpty(token)){
			throw new NullPointerException("token 不能为空！");
		}
		RawAccessToken rawAccessToken=new RawAccessToken(token);
		Jws<Claims> claims=rawAccessToken.parseClaims(new TokenProperties().getSigningKey());
		String username=(String) claims.getBody().get("sub");
	}
	
	
    @Bean
    public BasicAuthRequestInterceptor basicAuthorizationInterceptor() {
        return new BasicAuthRequestInterceptor("app01", "passwd01");
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}

