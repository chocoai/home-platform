package com.home.developer.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingDto;
import com.home.developer.server.domain.Building;
import com.home.developer.server.repository.BuildingRepository;
import com.home.developer.server.service.BuildingService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 楼盘表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void saveOrUpdateBuilding(BuildingDto param) {
        if (null == param.getId()) {
            // 添加
            Building save = new Building();
            BeanUtils.copyProperties(param, save);

            save.setCreateTime(new Date());
            save.setUpdateTime(save.getCreateTime());
            save.setDeleteFlag(false);

            Building building = buildingRepository.save(save);
            if (null == building || null == building.getId()) {
                throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER_BUILDING.getCode(), DeveloperExceptionCode.SAVE_DEVELOPER_BUILDING.getMessage());
            }
        } else {
            // 修改
            // TODO 修改楼盘信息
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteBuilding(Long... primaryKeys) {
        for (Long primaryKey : primaryKeys) {
            buildingRepository.deleteById(primaryKey);
        }
    }

    @Override
    public ResultVo<BuildingDto> findBuildingByPrimaryKey(Long primaryKey) {
        Building building = buildingRepository.findByIdAndDeleteFlag(primaryKey, false);
        if (null == building) {
            return ResultVo.dataEmpty();
        } else {
            BuildingDto buildingDto = new BuildingDto();
            BeanUtils.copyProperties(building, buildingDto);
            return ResultVo.ok(buildingDto);
        }
    }
}