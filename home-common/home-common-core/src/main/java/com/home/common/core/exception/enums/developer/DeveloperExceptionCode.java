package com.home.common.core.exception.enums.developer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 开发商相关异常码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 10:28
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum DeveloperExceptionCode {
    SAVE_DEVELOPER(3000, "添加开发商出现异常"),
    DEVELOPER_UN_EXISTED(3000, "开发商信息不存在"),
    SAVE_DEVELOPER_DEFAULT_OPERATION_AREA(3001, "添加开发商默认运营区域出现异常"),
    SAVE_DEVELOPER_OPERATION_AREA(3001, "添加开发商运营区域出现异常"),
    SAVE_DEVELOPER_DEFAULT_ACCOUNT(3001, "添加开发商默认账号出现异常"),
    SAVE_DEVELOPER_ACCOUNT(3001, "添加开发商出现异常"),
    SAVE_DEVELOPER_BUILDING(3001, "添加楼盘出现异常"),
    SAVE_DEVELOPER_BUILDING_POSITION(3001, "添加楼盘岗位出现异常"),

    ;
    private Integer code;
    private String message;
}
