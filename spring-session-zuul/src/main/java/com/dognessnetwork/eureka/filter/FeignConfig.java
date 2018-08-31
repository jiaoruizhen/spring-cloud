package com.dognessnetwork.eureka.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;

import com.netflix.servo.util.Strings;

import feign.RequestInterceptor;
/**
 * 通过这个配置zuul已经可以把cookie传到feign中了，那么feign要如何把cookie传到微服务中呢?我们可以通过feign的RequestInterceptor接口来实现
 * @author Administrator
 *
 */
@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            if (!Strings.isNullOrEmpty(sessionId)) {
                requestTemplate.header("Cookie", "SESSION=" + sessionId);
            }
        };
    }
}
