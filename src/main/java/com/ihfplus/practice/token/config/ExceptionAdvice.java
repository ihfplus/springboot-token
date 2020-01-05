package com.ihfplus.practice.token.config;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ihfplus.practice.token.dto.resp.CommonResponse;
import com.ihfplus.practice.token.dto.resp.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author feng.he
 * @title: ExceptionAdvice
 * @projectName springboot-token
 * @description: 统一 异常拦截处理
 * @date 2020/1/5 12:50
 */
@ControllerAdvice
@Component
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(value = JWTDecodeException.class)
    @ResponseBody
    public CommonResponse handleJWTDecodeException(JWTDecodeException e) {
        return CommonResponse.notPass(ErrorCode.TOKEN_DECODE_ERROR);
    }

    @ExceptionHandler(value = SignatureVerificationException.class)
    @ResponseBody
    public CommonResponse handleSignatureVerificationException(SignatureVerificationException e) {
        return CommonResponse.notPass(ErrorCode.TOKEN_SIGNATURE_ERROR);
    }

    @ExceptionHandler(value = TokenExpiredException.class)
    @ResponseBody
    public CommonResponse handleTokenExpiredException(TokenExpiredException e) {
        return CommonResponse.notPass(ErrorCode.TOKEN_EXPIRED);
    }

    @ExceptionHandler(value = InvalidClaimException.class)
    @ResponseBody
    public CommonResponse handleInvalidClaimException(InvalidClaimException e) {
        return CommonResponse.notPass(ErrorCode.TOKEN_INVALIDCLAIM);
    }
}
