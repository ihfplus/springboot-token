package com.ihfplus.practice.token.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ihfplus.practice.token.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author feng.he
 * @title: TokenService
 * @projectName springboot-token
 * @description: TODO
 * @date 2020/1/4 15:53
 */
@Service
@Slf4j
public class TokenService {

    /**
     * 生成 token
     *
     * @param userInfo
     * @return
     */
    public String genToken(UserInfo userInfo) {
        return JWT.create().withAudience(userInfo.getUserName()).sign(Algorithm.HMAC256(userInfo.getPassWord()));
    }

    /**
     * 验证 token
     *
     * @param token
     * @return
     */
    public boolean verifyToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        String head = decodedJWT.getHeader();
        String payload = decodedJWT.getPayload();
        String sign = decodedJWT.getSignature();

        List<String> audiences = decodedJWT.getAudience();


        log.info("head: " + head);
        log.info("payload: " + payload);
        log.info("sign: " + sign);

        log.info("audiences: " + audiences);

        return true;
    }

}
