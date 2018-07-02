package com.home.developer.server.repository;

import com.home.developer.server.domain.DeveloperOperationAccountLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 开发商运营区域管理账号登陆日志
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 9:51:36
*/
public interface DeveloperOperationAccountLoginLogRepository extends JpaRepository<DeveloperOperationAccountLoginLog,Long> {

}