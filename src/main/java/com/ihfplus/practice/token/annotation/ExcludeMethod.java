package com.ihfplus.practice.token.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author feng.he
 * @title: ExcludeMethod
 * @projectName springboot-token
 * @description: 排除
 * @date 2020/1/4 16:24
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcludeMethod {
}
