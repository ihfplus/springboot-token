package com.ihfplus.practice.token.controller;

import com.alibaba.fastjson.JSONObject;
import com.ihfplus.practice.token.annotation.ExcludeMethod;
import com.ihfplus.practice.token.dto.UserInfo;
import com.ihfplus.practice.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author feng.he
 * @title: UserController
 * @projectName springboot-token
 * @description: TODO
 * @date 2020/1/4 14:38
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private TokenService tokenService;

    @ExcludeMethod
    @PostMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestBody UserInfo userInfo) {
        //验证登录
        //登录成功，下发token
        String token = tokenService.genToken(userInfo);
        JSONObject resp = new JSONObject();
        resp.put("token", token);
        resp.put("user", userInfo);
        return resp;
    }

    @PostMapping("/say")
    public JSONObject sayHi() {
        JSONObject resp = new JSONObject();



        return resp;
    }

}
