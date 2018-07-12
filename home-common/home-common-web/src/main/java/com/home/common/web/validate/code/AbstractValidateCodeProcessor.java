package com.home.common.web.validate.code;

import com.home.common.core.exception.ValidateCodeException;
import com.home.common.core.exception.enums.system.SystemExceptionCode;
import com.home.common.web.validate.code.image.ImageValidateCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;
import java.util.UUID;

/**
 * 抽象验证码处理器实现类
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-30 15:07
 **/
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;
    @Autowired(required = false)
    private ValidateCodeRepository validateCodeRepository;

    @Override
    public ValidateCodeVo create(ServletWebRequest request) throws Exception {
        // 创建验证码
        C validateCode = generate(request);
        // 保存验证码到session中
        String random = save(validateCode);
        // 发送验证码
        send(request, validateCode);

        if (validateCode instanceof ImageValidateCode) {
            ImageValidateCode image = (ImageValidateCode) validateCode;
            return new ValidateCodeVo(image.getCode(), image.getImage());
        }

        ValidateCode code = validateCode;
        return new ValidateCodeVo(code.getCode());
    }

    /**
     * 创建验证码
     *
     * @param request ServletWebRequest
     * @return ValidateCode
     */
    private C generate(ServletWebRequest request) {
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException(SystemExceptionCode.VALIDATE_CODE_GENERATOR_NON.getCode(), SystemExceptionCode.VALIDATE_CODE_GENERATOR_NON.getMessage());
        }
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 保存校验码到session
     *
     * @param validateCode ValidateCode
     * @return random
     */
    private String save(C validateCode) {
        ValidateCode code = new ValidateCode(validateCode.getCode());
        String random = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        validateCodeRepository.save(random, code);
        return random;
    }

    /**
     * 根据请求的url获取校验码的类型
     *
     * @param request ServletWebRequest
     * @return ValidateCodeType
     */
    private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "ValidateCodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    /**
     * 验证码发送方法
     *
     * @param request      ServletWebRequest
     * @param validateCode ValidateCode
     * @throws Exception Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    @Override
    public void validate(String random, String code) throws ValidateCodeException {

        C cacheCodeObject = (C) validateCodeRepository.get(random);

        if (null == cacheCodeObject) {
            throw new ValidateCodeException(SystemExceptionCode.VALIDATE_CODE_NON.getCode(), SystemExceptionCode.VALIDATE_CODE_NON.getMessage());
        }

        String cacheCode = cacheCodeObject.toString();

        if (StringUtils.isEmpty(code)) {
            validateCodeRepository.get(random);
            throw new ValidateCodeException(SystemExceptionCode.VALIDATE_CODE_INPUT_NON.getCode(), SystemExceptionCode.VALIDATE_CODE_INPUT_NON.getMessage());
        }

        if (StringUtils.isEmpty(cacheCode)) {
            validateCodeRepository.get(random);
            throw new ValidateCodeException(SystemExceptionCode.VALIDATE_CODE_EXPIRE.getCode(), SystemExceptionCode.VALIDATE_CODE_EXPIRE.getMessage());
        }

        if (!StringUtils.equals(cacheCode, code)) {
            validateCodeRepository.get(random);
            throw new ValidateCodeException(SystemExceptionCode.VALIDATE_CODE_NON_MATCH.getCode(), SystemExceptionCode.VALIDATE_CODE_NON_MATCH.getMessage());
        }
        validateCodeRepository.get(random);
    }
}
