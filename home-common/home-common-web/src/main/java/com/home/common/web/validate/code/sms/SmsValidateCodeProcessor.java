package com.home.common.web.validate.code.sms;


import com.home.common.web.validate.code.AbstractValidateCodeProcessor;
import com.home.system.server.component.validate.code.ValidateCode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码发送实现
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-18 12:35
 **/
@Component("smsValidateCodeProcessor")
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor {



    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");
        // TODO 手机发送短信
    }

}
