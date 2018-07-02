package com.home.developer.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingDto;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.developer.server.domain.Building;
import com.home.developer.server.domain.BuildingPosition;
import com.home.developer.server.repository.BuildingPositionRepository;
import com.home.developer.server.service.BuildingPositionService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 楼盘职位 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class BuildingPositionServiceImpl implements BuildingPositionService {

    @Autowired
    private BuildingPositionRepository buildingPositionRepository;

    @Override
    public void saveOrUpdateBuildingPosition(BuildingPositionDto param) {
        if (null == param.getId()) {
            // 添加楼盘岗位
            BuildingPosition save = new BuildingPosition();
            BeanUtils.copyProperties(param, save);

            save.setCreateTime(new Date());
            save.setUpdateTime(save.getCreateTime());
            save.setDeleteFlag(false);

            BuildingPosition buildingPosition = buildingPositionRepository.save(save);
            if (null == buildingPosition || null == buildingPosition.getId()) {
                throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER_BUILDING_POSITION.getCode(), DeveloperExceptionCode.SAVE_DEVELOPER_BUILDING_POSITION.getMessage());
            }
        } else {
            // 修改
            // TODO 修改楼盘岗位
        }
    }

    @Override
    public ResultVo<BuildingPositionDto> findBuildingPositionByPrimaryKey(Long primaryKey) {
        BuildingPosition buildingPosition = buildingPositionRepository.findByIdAndDeleteFlag(primaryKey, false);
        if (null == buildingPosition) {
            return ResultVo.dataEmpty();
        } else {
            BuildingPositionDto buildingPositionDto = new BuildingPositionDto();
            BeanUtils.copyProperties(buildingPosition, buildingPositionDto);
            return ResultVo.ok(buildingPositionDto);
        }
    }
}