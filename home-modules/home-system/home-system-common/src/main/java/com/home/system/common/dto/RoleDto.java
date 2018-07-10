package com.home.system.common.dto;

import lombok.Data;

/**
 * 角色
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-10 10:45
 **/
@Data
public class RoleDto {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 备注
     */
    private String remark;
}
