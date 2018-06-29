package com.home.employee.server.service.impl;

import com.home.employee.server.domain.EmployeeBuildingPosition;
import com.home.employee.server.repository.EmployeeBuildingPositionRepository;
import com.home.employee.server.service.EmployeeBuildingPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工开发商楼盘职位表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-6-29 16:05:46
 */
@Service
public class EmployeeBuildingPositionServiceImpl implements EmployeeBuildingPositionService{

    @Autowired
    private EmployeeBuildingPositionRepository employeeBuildingPositionRepository;

}