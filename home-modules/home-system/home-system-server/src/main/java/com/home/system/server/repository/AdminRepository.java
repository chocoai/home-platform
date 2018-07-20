package com.home.system.server.repository;

import com.home.system.server.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 管理员
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface AdminRepository extends JpaRepository<Admin,Long> , JpaSpecificationExecutor<Admin>{

    /**
     * 根据账号获取Admin
     * @param account 账号
     * @return Admin
     */
    Admin findAdminByAccount(String account);

}