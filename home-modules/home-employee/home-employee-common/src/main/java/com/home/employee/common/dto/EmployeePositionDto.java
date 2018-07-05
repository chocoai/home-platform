package com.home.employee.common.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 16:35
 **/
@Data
public class EmployeePositionDto {

    /**
     * 员工Id
     */
    private Long employeeId;
    /**
     * 楼盘岗位Id
     */
    private Long buildingPositionId;
    /**
     * 分销商职位Id
     */
    private Long distributionPositionId;

}
