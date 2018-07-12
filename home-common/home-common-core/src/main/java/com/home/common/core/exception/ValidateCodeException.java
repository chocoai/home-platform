package com.home.common.core.exception;

/**
 * 验证码相关一次
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:49
 **/
public class ValidateCodeException extends HomeCustomException {
    public ValidateCodeException(Integer code, String msg) {
        super(code,msg);
    }
}
