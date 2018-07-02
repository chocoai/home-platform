package com.home.employee.server.repository;

import com.home.employee.server.domain.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 员工证件信息表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 18:07:28
*/
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Long> {

}