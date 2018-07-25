package com.home.system.common.vo;

import lombok.Data;

/**
 * 角色分配权限
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-24 18:05
 **/
@Data
public class RoleAuthorizationVo {

    private Long roleId;

    private Long[] authorizationIds;
}
