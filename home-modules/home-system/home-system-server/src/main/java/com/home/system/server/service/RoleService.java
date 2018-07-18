package com.home.system.server.service;

import com.home.system.common.vo.RoleVo;
import com.home.system.server.domain.Role;

import java.util.List;

/**
 * 角色 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface RoleService{

    /**
     * 根据管理员Id查询角色
     * @param adminId 管理Id
     * @return List<RoleVo>
     */
    List<RoleVo> findRoleByAdminId(Long adminId);
}