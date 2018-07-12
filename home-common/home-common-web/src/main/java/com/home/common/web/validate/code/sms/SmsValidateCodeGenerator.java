package com.home.common.web.validate.code.sms;


import com.home.common.web.validate.code.ValidateCodeGenerator;
import com.home.system.server.component.validate.code.config.ValidateCodeProperties;
import com.home.system.server.component.validate.code.ValidateCode;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图形验证码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-30 15:09
 **/
@Component("smsValidateCodeGenerator")
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired(required = false)
    private ValidateCodeProperties validateCodeProperties;

    /**
     * 创建验证码图片
     * @param request HttpServletRequest
     * @return ImageCode
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(validateCodeProperties.getSms().getLength());
        return new ValidateCode(code);
    }


}
