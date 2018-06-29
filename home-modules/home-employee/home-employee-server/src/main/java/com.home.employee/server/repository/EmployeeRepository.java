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
 * @create 2018-6-29 16:05:46
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * 修改 Employee
     * @param staffName
     * @param mobile
     * @param email
     * @param headImage
     * @param employeePassword
     * @param maritalStatus
     * @param id
     * @return 影响行数
     */
    @Query("UPDATE Employee SET staffName = :staffName, mobile = :mobile, email = :email, headImage =:headImage, employeePassword = :employeePassword, maritalStatus = :maritalStatus WHERE id =:id")
    @Modifying
    int modifyEmployeeByPrimaryKey(@Param("staffName") String staffName,
                                   @Param("mobile") String mobile,
                                   @Param("email") String email,
                                   @Param("headImage") String headImage,
                                   @Param("employeePassword") String employeePassword,
                                   @Param("maritalStatus") Boolean maritalStatus,
                                   @Param("id") Long id);
}