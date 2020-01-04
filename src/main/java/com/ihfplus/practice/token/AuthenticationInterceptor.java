package com.ihfplus.practice.token;

import com.ihfplus.practice.token.annotation.ExcludeMethod;
import com.ihfplus.practice.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author feng.he
 * @title: AuthenticationInterceptor
 * @projectName springboot-token
 * @description: token校验
 * @date 2020/1/4 14:19
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    //验证Token
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //判断请求是否需要拦截，不需要，直接放行；

        //需要，拦截
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        boolean ckExclution = handlerMethod.getMethod().isAnnotationPresent(ExcludeMethod.class);
        if (ckExclution) {
            return true;
        }

        String token = request.getHeader("token");
        if (token == null) {
            return false;
        }
        boolean result = tokenService.verifyToken(token);
        if (!result) {
            return false;
        }
        return true;
    }

}
