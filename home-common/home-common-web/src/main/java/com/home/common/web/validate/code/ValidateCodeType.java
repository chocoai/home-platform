package com.home.common.web.validate.code;

/**
 * 验证码类型
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:34
 **/
public enum ValidateCodeType {
    /**
     * 短信验证码
     */
    SMS{
        @Override
        public String getValidateCodeType(){
            return "sms";
        }
    },
    /**
     * 图片验证码
     */
    IMAGE{
        @Override
        public String getValidateCodeType(){
            return "image";
        }
    };

    /**
     * 获取验证码类型
     * @return 验证码类型
     */
    public abstract String getValidateCodeType();
}
