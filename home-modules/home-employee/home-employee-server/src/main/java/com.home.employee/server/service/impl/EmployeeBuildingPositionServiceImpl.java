package com.home.employee.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.developer.client.DeveloperClient;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.employee.common.dto.EmployeePositionDto;
import com.home.employee.server.domain.EmployeeBuildingPosition;
import com.home.employee.server.repository.EmployeeBuildingPositionRepository;
import com.home.employee.server.service.EmployeeBuildingPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 员工开发商楼盘职位表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeBuildingPositionServiceImpl implements EmployeeBuildingPositionService{

    @Autowired
    private EmployeeBuildingPositionRepository employeeBuildingPositionRepository;

    @Autowired(required = false)
    private DeveloperClient developerClient;

    @Override
    public void developerSubmitPosition(EmployeePositionDto param) {
        // 验证岗位合法性
        ResultVo<BuildingPositionDto> buildingPositionDtoResultVo = developerClient.findBuildingPosition(param.getBuildingPositionId());
        BuildingPositionDto buildingPositionDto = (BuildingPositionDto) ResultVo.verifyResponse(buildingPositionDtoResultVo);
        if (null == buildingPositionDto) {
            throw new HomeCustomException(DeveloperExceptionCode.DEVELOPER_BUILDING_POSITION.getCode(), DeveloperExceptionCode.DEVELOPER_BUILDING_POSITION.getMessage());
        }

        EmployeeBuildingPosition save = new EmployeeBuildingPosition();
        save.setEmployeeId(param.getEmployeeId());
        save.setBuildingId(buildingPositionDto.getBuildingId());
        save.setBuildingPositionId(buildingPositionDto.getId());
        save.setDeveloperId(buildingPositionDto.getDeveloperId());
        save.setOperationAreaId(buildingPositionDto.getOperationAreaId());
        save.setWorkState(false);
        save.setEntryTime(new Date());

        save.setCreateTime(new Date());
        save.setUpdateTime(save.getCreateTime());
        save.setDeleteFlag(false);

        employeeBuildingPositionRepository.save(save);
    }
}