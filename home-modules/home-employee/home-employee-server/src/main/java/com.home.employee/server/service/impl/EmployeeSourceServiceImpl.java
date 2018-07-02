package com.home.employee.server.service.impl;

import com.home.employee.server.domain.EmployeeSource;
import com.home.employee.server.repository.EmployeeSourceRepository;
import com.home.employee.server.service.EmployeeSourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工来源信息表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeSourceServiceImpl implements EmployeeSourceService{

    @Autowired
    private EmployeeSourceRepository employeeSourceRepository;

}