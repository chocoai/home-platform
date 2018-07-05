package com.home.common.core.exception.enums.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-05 10:04
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  EmployeeExceptionCode {
    SAVE_EMPLOYEE_FAIL(4000,"添加员工出现异常"),

            ;

    private Integer code;
    private String message;
}
