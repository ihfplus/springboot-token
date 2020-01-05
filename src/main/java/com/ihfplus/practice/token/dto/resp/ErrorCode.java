package com.ihfplus.practice.token.dto.resp;

/**
 * @author feng.he
 * @title: ErrorCode
 * @projectName springboot-token
 * @description: 错误码
 * @date 2020/1/5 10:59
 */
public enum ErrorCode {

    SUCCESS("000", "成功"),
    TOKEN_DECODE_ERROR("100", "解析异常"),
    TOKEN_EXPIRED("101", "Token超时"),
    TOKEN_SIGNATURE_ERROR("102", "签名异常"),
    TOKEN_INVALIDCLAIM("103", "声明异常");


    private String code;

    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
