package com.home.system.server.service;

import com.home.system.server.domain.AdminRole;

/**
 * 管理员角色关联 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface AdminRoleService{

    /**
     * 管理员分配角色
     * @param adminId 管理员Id
     * @param roleIds 角色Id
     */
    void adminAssignRole(Long adminId,Long...roleIds);
}