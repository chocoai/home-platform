package com.home.system.server.repository;

import com.home.system.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 角色
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface RoleRepository extends JpaRepository<Role,Long> {

}