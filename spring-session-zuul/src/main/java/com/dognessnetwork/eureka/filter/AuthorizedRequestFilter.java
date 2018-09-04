package com.dognessnetwork.eureka.filter;



import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AuthorizedRequestFilter extends ZuulFilter {    // 进行授权访问处理

	public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //添加Basic Auth认证信息
        ctx.addZuulRequestHeader("Authorization", "Basic " + getBase64Credentials("app01", "passwd01"));
        return null;
    }
private String getBase64Credentials(String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }


    @Override
    public boolean shouldFilter() {    // 该Filter是否要执行
        return true ;
    }

    @Override
    public int filterOrder() {
        return 0;    // 设置优先级，数字越大优先级越低
    }

    @Override
    public String filterType() {
        // 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
        // 1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
        // 2、route：在进行路由请求的时候被调用；
        // 3、post：在路由之后发送请求信息的时候被调用；
        // 4、error：出现错误之后进行调用
        return "pre";
    }

}