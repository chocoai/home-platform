package com.home.employee.server.service;

import com.home.employee.server.domain.EmployeeSource;

/**
 * 员工来源信息表 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
public interface EmployeeSourceService {

    /**
     * 添加员工来源
     *
     * @param developerId     开发商Id
     * @param operationAreaId 开发商运营区域
     * @param buildingId      楼盘Id
     * @param distributionId      分销商Id
     * @param employeeId      员工Id
     */
    void saveEmployeeSource(Long developerId, Long operationAreaId, Long buildingId, Long distributionId, Long employeeId);
}