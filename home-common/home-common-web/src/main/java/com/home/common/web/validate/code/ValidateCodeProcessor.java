package com.home.common.web.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-30 15:07
 **/
public interface ValidateCodeProcessor {

    /**
     * 处理验证码请求
     *
     * @param request ServletWebRequest
     * @return ValidateCodeVo
     * @throws Exception Exception
     */
    ValidateCodeVo create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param random 随机数
     * @param code   输入验证码
     * @throws Exception Exception
     */
    void validate(String random, String code);
}
