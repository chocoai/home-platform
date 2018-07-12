package com.home.common.web.validate.code;

import com.home.common.core.exception.ValidateCodeException;
import com.home.common.core.exception.enums.system.SystemExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  匹配验证码处理器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-18 13:06
 **/
@Component
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;


    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException(SystemExceptionCode.VALIDATE_CODE_GENERATOR_NON.getCode(), SystemExceptionCode.VALIDATE_CODE_GENERATOR_NON.getMessage());
        }
        return processor;
    }

}
