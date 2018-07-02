package com.home.developer.server.service;

import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.developer.server.domain.BuildingPosition;

/**
 * 楼盘职位 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface BuildingPositionService{

    /**
     *  添加、修改 楼盘岗位
     * @param param BuildingPositionDto
     */
    void saveOrUpdateBuildingPosition(BuildingPositionDto param);

    /**
     * 根据楼盘岗位Id 获取详情
     * @param primaryKey 主键Id
     * @return ResultVo<BuildingPositionDto>
     */
    ResultVo<BuildingPositionDto> findBuildingPositionByPrimaryKey(Long primaryKey);
}