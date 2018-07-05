package com.home.employee.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.employee.common.dto.EmployeePositionDto;
import com.home.employee.server.domain.EmployeeBuildingPosition;
import com.home.employee.server.domain.EmployeeDistributionPosition;
import com.home.employee.server.repository.EmployeeDistributionPositionRepository;
import com.home.employee.server.service.EmployeeDistributionPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 员工开分销商职位表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeDistributionPositionServiceImpl implements EmployeeDistributionPositionService{

    @Autowired
    private EmployeeDistributionPositionRepository employeeDistributionPositionRepository;

    @Override
    public void distributionSubmitPosition(EmployeePositionDto param) {
        // 验证岗位合法性
        // TODO 分销商员工分配岗位
    }
}