package com.home.employee.server.service.impl;

import com.home.employee.server.domain.EmployeeDistributionPosition;
import com.home.employee.server.repository.EmployeeDistributionPositionRepository;
import com.home.employee.server.service.EmployeeDistributionPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工开分销商职位表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-6-29 16:05:46
 */
@Service
public class EmployeeDistributionPositionServiceImpl implements EmployeeDistributionPositionService{

    @Autowired
    private EmployeeDistributionPositionRepository employeeDistributionPositionRepository;

}