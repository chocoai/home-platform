package com.home.system.server.repository;

import com.home.system.server.domain.RoleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 角色权限关联
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface RoleAuthorizationRepository extends JpaRepository<RoleAuthorization,Long> {

}