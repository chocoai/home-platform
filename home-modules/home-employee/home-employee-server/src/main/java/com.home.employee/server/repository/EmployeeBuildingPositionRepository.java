package com.home.employee.server.repository;

import com.home.employee.server.domain.EmployeeBuildingPosition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 员工开发商楼盘职位表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 18:07:28
*/
public interface EmployeeBuildingPositionRepository extends JpaRepository<EmployeeBuildingPosition,Long> {

}