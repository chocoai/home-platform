package com.home.developer.server.service;

import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingDto;
import com.home.developer.server.domain.Building;

/**
 * 楼盘表 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface BuildingService {

    /**
     * 添加、修改 楼盘信息
     *
     * @param param BuildingDto
     */
    void saveOrUpdateBuilding(BuildingDto param);

    /**
     * 删除楼盘
     *
     * @param primaryKeys 主键Id集合
     */
    void deleteBuilding(Long... primaryKeys);

    /**
     * 根据主键获取楼盘信息
     *
     * @param primaryKey 主键
     * @return ResultVo<BuildingDto>
     */
    ResultVo<BuildingDto> findBuildingByPrimaryKey(Long primaryKey);
}