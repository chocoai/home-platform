package com.home.system.server.repository;

import com.home.system.server.domain.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 管理员角色关联
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface AdminRoleRepository extends JpaRepository<AdminRole,Long> {

}