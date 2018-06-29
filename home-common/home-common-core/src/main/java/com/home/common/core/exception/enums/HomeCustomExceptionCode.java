package com.home.common.core.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * home系统自定义异常响应码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 17:02
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum HomeCustomExceptionCode {
    UN_EXIST(2000,"记录不存在"),
    MODIFY_FAIL(2001,"修改记录失败"),
    ;
    private Integer code;
    private String message;
}
