package com.home.employee.server.service.impl;

import com.home.employee.server.domain.EmployeeSource;
import com.home.employee.server.repository.EmployeeSourceRepository;
import com.home.employee.server.service.EmployeeSourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 员工来源信息表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeSourceServiceImpl implements EmployeeSourceService {

    @Autowired
    private EmployeeSourceRepository employeeSourceRepository;

    @Override
    public void saveEmployeeSource(Long developerId, Long operationAreaId, Long buildingId, Long distributionId, Long employeeId) {
        EmployeeSource save = new EmployeeSource();
        save.setBuildingId(buildingId);
        save.setDeveloperId(developerId);
        save.setOperationAreaId(operationAreaId);

        save.setDistributionId(distributionId);

        save.setEmployeeId(employeeId);

        save.setCreateTime(new Date());
        save.setUpdateTime(save.getCreateTime());
        save.setDeleteFlag(false);

        employeeSourceRepository.save(save);
    }
}