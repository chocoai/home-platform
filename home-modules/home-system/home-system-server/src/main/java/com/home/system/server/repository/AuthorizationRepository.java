package com.home.system.server.repository;

import com.home.system.server.domain.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 权限
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    /**
     * 根据角色名获取全新啊
     *
     * @param roleName 角色名
     * @return List<Authorization>
     */
    @Query(value = "SELECT a.* FROM sys_authorization a " +
            "INNER JOIN sys_role_authorization ra ON a.id = ra.authorization_id " +
            "INNER JOIN sys_role r ON ra.role_id = r.id " +
            "WHERE r.role_name = :roleName " +
            "AND a.delete_flag = 0 " +
            "AND ra.delete_flag = 0", nativeQuery = true)
    List<Authorization> findByRoleName(@Param("roleName") String roleName);

    /**
     * 根据账号和父节点 获取权限
     *
     * @param account  账号
     * @param parentId 父节点
     * @return st<Authorization>
     */
    @Query(value = "SELECT a.* FROM sys_authorization a " +
            "INNER JOIN sys_role_authorization ra ON a.id = ra.authorization_id " +
            "INNER JOIN sys_role r ON r.id = ra.role_id " +
            "INNER JOIN sys_admin_role ar ON ar.role_id = r.id " +
            "INNER JOIN sys_admin ad ON ar.admin_id = ad.id " +
            "WHERE ad.account = :account " +
            "AND a.parent_id = :parentId " +
            "AND ar.delete_flag = 0 " +
            "AND r.delete_flag = 0 " +
            "AND ra.delete_flag = 0 " +
            "AND a.delete_flag = 0", nativeQuery = true)
    List<Authorization> findByAccountAndParentId(@Param("account") String account, @Param("parentId") Long parentId);
}