package com.ihfplus.practice.token.dto.resp;

import lombok.Data;

/**
 * @author feng.he
 * @title: CommonResponse
 * @projectName springboot-token
 * @description: 通用响应
 * @date 2020/1/5 10:28
 */
@Data
public class CommonResponse {

    /**
     * 描述
     */
    private String msg;

    /**
     * 响应码
     */
    private String code;


    public static CommonResponse notPass(String code, String msg) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(code);
        commonResponse.setMsg(msg);
        return commonResponse;
    }

    public static CommonResponse notPass(ErrorCode errorCode) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(errorCode.getCode());
        commonResponse.setMsg(errorCode.getMsg());
        return commonResponse;
    }

    public static CommonResponse success() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ErrorCode.SUCCESS.getCode());
        commonResponse.setMsg(ErrorCode.SUCCESS.getMsg());
        return commonResponse;
    }

}
