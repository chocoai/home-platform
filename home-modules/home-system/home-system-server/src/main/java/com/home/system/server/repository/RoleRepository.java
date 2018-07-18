package com.home.system.server.repository;

import com.home.system.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
* 角色
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface RoleRepository extends JpaRepository<Role,Long> {

    /**
     * 根据管理员Id查询角色
     * @param adminId 管理员Id
     * @return 角色
     */
    @Query(value = "SELECT r.* FROM sys_role r INNER JOIN  sys_admin_role ar ON r.id = ar.role_id WHERE ar.admin_id = :adminId AND ar.delete_flag = 0",nativeQuery = true)
    List<Role> findByAdminId(@Param("adminId") Long adminId);
}