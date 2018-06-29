package com.home.employee.server.repository;

import com.home.employee.server.domain.EmployeeBuildingPosition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 员工开发商楼盘职位表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-6-29 16:05:46
*/
public interface EmployeeBuildingPositionRepository extends JpaRepository<EmployeeBuildingPosition,Long> {

}