package com.home.common.web.validate.code;

import java.io.Serializable;

/**
 * 验证码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-17 16:40
 **/
public class ValidateCode implements Serializable{

    /**
     * 验证码
     */
    private String code;

    public ValidateCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
