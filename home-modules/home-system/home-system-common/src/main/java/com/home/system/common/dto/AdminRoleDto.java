package com.home.system.common.dto;

import lombok.Data;

/**
 * 管理员分配角色参数
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-20 15:26
 **/
@Data
public class AdminRoleDto {


    private Long adminId;

    private Long[] roleIds;
}
