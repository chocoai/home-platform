package com.home.system.server.repository;

import com.home.system.server.domain.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 管理员登录日志
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-9 18:37:14
*/
public interface AdminLogRepository extends JpaRepository<AdminLog,Long> {

}