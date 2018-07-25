package com.home.system.server.repository;

import com.home.system.server.domain.RoleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 角色权限关联
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface RoleAuthorizationRepository extends JpaRepository<RoleAuthorization, Long> {

    /**
     * 获取所有角色权限关联数据
     *
     * @param roleId     角色Id
     * @param deleteFlag 删除标志
     * @return List<RoleAuthorization>
     */
    List<RoleAuthorization> findByRoleIdAndDeleteFlag(Long roleId, Boolean deleteFlag);

    /**
     * 根据 roleId 获取已分配的权限Id集合
     *
     * @param roleId  角色Id
     * @param parentId 父节点
     * @return List<Long>
     */
    @Query(value = "SELECT ra.* FROM sys_authorization a " +
            "INNER JOIN sys_role_authorization ra ON a.id = ra.authorization_id " +
            "INNER JOIN sys_role r ON r.id = ra.role_id " +
            "WHERE r.id = :roleId AND a.parent_id = :parentId " +
            "AND r.delete_flag = 0 " +
            "AND ra.delete_flag = 0 " +
            "AND a.delete_flag = 0", nativeQuery = true)
    List<RoleAuthorization> findHasAuthorizationByRoleId(@Param("roleId") Long roleId, @Param("parentId") Long parentId);
}