package com.ihfplus.practice.token.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTPartsParser;
import com.ihfplus.practice.token.dto.UserInfo;
import com.ihfplus.practice.token.dto.resp.CommonResponse;
import com.ihfplus.practice.token.dto.resp.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SignatureException;
import java.util.Date;
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

    final String secret = "123";

    /**
     * 生成 token
     *
     * @param userInfo
     * @return
     */
    public String genToken(UserInfo userInfo) {
        return JWT.create().withAudience(userInfo.getUserName())
                //.withExpiresAt(new Date()) //测试超时
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证 token
     * <p>
     * 如何验证token 是否有效
     *
     * @param token
     * @return
     */
    public CommonResponse verifyToken(String token) {
        DecodedJWT decodedJWT = null;

        //构建一个JWTVerifier
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        //try {
        decodedJWT = jwtVerifier.verify(token);
        // }

//        catch (JWTDecodeException e) {
//            return CommonResponse.notPass(ErrorCode.TOKEN_DECODE_ERROR);
//        }
//        catch (SignatureVerificationException e) {
//            return CommonResponse.notPass(ErrorCode.TOKEN_SIGNATURE_ERROR);
//        } catch (TokenExpiredException e) {
//            return CommonResponse.notPass(ErrorCode.TOKEN_EXPIRED);
//        } catch (InvalidClaimException e) {
//            return CommonResponse.notPass(ErrorCode.TOKEN_INVALIDCLAIM);
//        }

        String head = decodedJWT.getHeader();
        String payload = decodedJWT.getPayload();
        String sign = decodedJWT.getSignature();

        //head
        String alg = decodedJWT.getAlgorithm();
        String type = decodedJWT.getType();

        //payload 公共声明
        String is = decodedJWT.getIssuer();
        Date eat = decodedJWT.getExpiresAt();
        String sub = decodedJWT.getSubject();
        List<String> audiences = decodedJWT.getAudience();
        Date nbf = decodedJWT.getNotBefore();
        Date iat = decodedJWT.getIssuedAt();

        log.info("head: " + head);
        log.info("payload: " + payload);
        log.info("sign: " + sign);
        return CommonResponse.success();
    }
}
