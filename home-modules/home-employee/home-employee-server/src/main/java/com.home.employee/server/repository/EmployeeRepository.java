package com.home.employee.server.repository;

import com.home.employee.server.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* 员工信息表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 18:07:28
*/
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    /**
     * 修改 Employee
     * @param employeeName
     * @param mobile
     * @param email
     * @param headImage
     * @param employeePassword
     * @param maritalStatus
     * @param id
     * @return
     */
    @Query("UPDATE Employee SET employeeName = :employeeName, mobile = :mobile, email = :email, headImage =:headImage, employeePassword = :employeePassword, maritalStatus = :maritalStatus WHERE id =:id")
    @Modifying
    int modifyEmployeeByPrimaryKey(@Param("employeeName") String employeeName,
                                   @Param("mobile") String mobile,
                                   @Param("email") String email,
                                   @Param("headImage") String headImage,
                                   @Param("employeePassword") String employeePassword,
                                   @Param("maritalStatus") Boolean maritalStatus,
                                   @Param("id") Long id);
}