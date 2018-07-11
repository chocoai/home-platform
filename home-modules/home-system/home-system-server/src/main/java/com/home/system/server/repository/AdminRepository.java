package com.home.system.server.repository;

import com.home.system.server.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 管理员
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface AdminRepository extends JpaRepository<Admin,Long> {

    /**
     * 根据账号获取Admin
     * @param account 账号
     * @return Admin
     */
    Admin findAdminByAccount(String account);
}