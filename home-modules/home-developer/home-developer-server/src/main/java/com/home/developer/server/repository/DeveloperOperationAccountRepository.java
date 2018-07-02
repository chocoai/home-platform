package com.home.developer.server.repository;

import com.home.developer.server.domain.DeveloperOperationAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 开发商运营区域管理账号
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 9:51:36
*/
public interface DeveloperOperationAccountRepository extends JpaRepository<DeveloperOperationAccount,Long> {

}