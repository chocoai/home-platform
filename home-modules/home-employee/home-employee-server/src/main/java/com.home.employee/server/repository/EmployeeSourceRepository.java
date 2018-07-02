package com.home.employee.server.repository;

import com.home.employee.server.domain.EmployeeSource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 员工来源信息表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 18:07:28
*/
public interface EmployeeSourceRepository extends JpaRepository<EmployeeSource,Long> {

}