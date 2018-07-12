package com.home.common.web.validate.code.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 验证码相关配置
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:17
 **/
@ConfigurationProperties(prefix = "custom.security.code")
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }
}
