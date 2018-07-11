package com.home.system.server.repository;

import com.home.system.server.domain.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 权限
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface AuthorizationRepository extends JpaRepository<Authorization,Long> {

}