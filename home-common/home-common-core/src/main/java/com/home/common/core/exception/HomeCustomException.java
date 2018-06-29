package com.home.common.core.exception;

/**
 * 快的看房自定义异常
 *
 * @author roger.
 * @email 190642964@qq.com
 * @create 2017-03-30
 */
public class HomeCustomException extends RuntimeException {

    private Integer code;

    public HomeCustomException() {
        super();
    }

    public HomeCustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
