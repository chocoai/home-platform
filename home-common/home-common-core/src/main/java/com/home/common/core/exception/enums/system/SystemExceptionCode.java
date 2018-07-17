package com.home.common.core.exception.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:58
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SystemExceptionCode {
    VALIDATE_CODE_NON(2000, "验证码为空或已过期"),
    VALIDATE_CODE_INPUT_NON(2001, "验证码为空"),
    VALIDATE_CODE_EXPIRE(2002, "验证码已过期"),
    VALIDATE_CODE_NON_MATCH(2003, "验证码不匹配"),
    VALIDATE_CODE_GENERATOR_NON(2004, "当前验证码生成器不支持"),
    ;

    private Integer code;
    private String message;
}
