package com.home.common.web.validate.code;

/**
 * 验证码保存
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-24 17:53
 **/
public interface ValidateCodeRepository {

    /**
     * 存储验证码
     *
     * @param random 随机数
     * @param code ValidateCode
     */
    void save(String random,ValidateCode code);

    /**
     * 获取验证码
     *
     * @return random 随机数
     */
    ValidateCode get(String random);

    /**
     * 移除验证码
     *
     * @param random 随机数
     */
    void remove(String random);
}
