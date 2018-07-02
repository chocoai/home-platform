package com.home.employee.server.service.impl;

import com.home.employee.server.domain.EmployeeCard;
import com.home.employee.server.repository.EmployeeCardRepository;
import com.home.employee.server.service.EmployeeCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工证件信息表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeCardServiceImpl implements EmployeeCardService{

    @Autowired
    private EmployeeCardRepository employeeCardRepository;

}