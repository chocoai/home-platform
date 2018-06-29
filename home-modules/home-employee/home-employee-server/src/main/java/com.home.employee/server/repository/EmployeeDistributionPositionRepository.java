package com.home.employee.server.repository;

import com.home.employee.server.domain.EmployeeDistributionPosition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 员工开分销商职位表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-6-29 16:05:46
*/
public interface EmployeeDistributionPositionRepository extends JpaRepository<EmployeeDistributionPosition,Long> {

}