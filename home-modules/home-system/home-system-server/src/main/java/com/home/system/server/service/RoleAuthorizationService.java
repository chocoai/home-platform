package com.home.system.server.service;

import com.home.system.server.domain.RoleAuthorization;

import java.util.List;
import java.util.Set;

/**
 * 角色权限关联 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface RoleAuthorizationService{

    /**
     * 根据角色获取已经分配的权限
     * @param roleId 角色Id
     * @return List<RoleAuthorization>
     */
    List<RoleAuthorization> findRoleAuthorizationByRoleId(Long roleId);

    /**
     * 删除关联信息
     * @param param List<RoleAuthorization>
     */
    void deleteRoleAuthorization(List<RoleAuthorization> param);

    /**
     * 添加关联信息
     * @param param List<RoleAuthorization>
     */
    void saveRoleAuthorization(List<RoleAuthorization> param);

    /**
     * 根据 roleId 获取已有的权限Id集合 - 所有子节点
     *
     * @param roleId 角色Id
     * @return Set<Long>
     */
    Set<Long> findHasAuthorizationByRoleId(Long roleId);
}