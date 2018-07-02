package com.home.developer.server.service;

import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.DeveloperDto;
import com.home.developer.server.domain.Developer;

/**
 * 开发商 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface DeveloperService{

    /**
     * 开发商添加 or 修改
     * @param param DeveloperDto
     */
    void saveOrUpdate(DeveloperDto param);

    /**
     * 根据主键Id获取开发商详情
     * @param primaryKey 主键Id
     * @return ResultVo<DeveloperDto>
     */
    ResultVo<DeveloperDto> findDeveloperByPrimaryKey(Long primaryKey);
}