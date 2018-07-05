package com.home.employee.server.service;

import com.home.employee.common.dto.EmployeePositionDto;
import com.home.employee.server.domain.EmployeeBuildingPosition;

/**
 * 员工开发商楼盘职位表 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
public interface EmployeeBuildingPositionService{


    /**
     * 开发商 分配 员工岗位
     * @param param EmployeePositionDto
     */
    void developerSubmitPosition(EmployeePositionDto param);
}