package com.home.employee.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.HomeCustomExceptionCode;
import com.home.employee.common.dto.EmployeeDto;
import com.home.employee.server.domain.Employee;
import com.home.employee.server.repository.EmployeeRepository;
import com.home.employee.server.service.EmployeeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 员工信息表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(rollbackFor = {HomeCustomException.class,Exception.class})
    public void save(EmployeeDto param) {
        if (param.getId() == null) {
            // 添加员工
            Employee employee = new Employee();
            BeanUtils.copyProperties(param, employee);
            employeeRepository.save(employee);
        } else {
            // 修改员工
            Optional<Employee> employeeOptional = employeeRepository.findById(param.getId());
            if (!employeeOptional.isPresent()) {
                throw new HomeCustomException(HomeCustomExceptionCode.UN_EXIST.getCode(),HomeCustomExceptionCode.UN_EXIST.getMessage());
            }

            int row = employeeRepository.modifyEmployeeByPrimaryKey(param.getStaffName(), param.getMobile(), param.getEmail(), param.getHeadImage(), param.getEmployeePassword(), param.getMaritalStatus(), param.getId());
            if (row <= 0){
                throw new HomeCustomException(HomeCustomExceptionCode.MODIFY_FAIL.getCode(),HomeCustomExceptionCode.MODIFY_FAIL.getMessage());
            }
        }
    }
}