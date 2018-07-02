package com.home.developer.server.service;

import com.home.developer.server.domain.DeveloperOperationArea;

/**
 * 开发商运营区域 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface DeveloperOperationAreaService {

    /**
     * 添加开发商 默认运营区域
     *
     * @param developerId       开发商Id
     * @param operationAreaName 开发商别名
     * @return DeveloperOperationArea
     */
    DeveloperOperationArea saveDefaultDeveloperOperationArea(Long developerId, String operationAreaName);

    /**
     * 添加开发商 运营区域
     *
     * @param operationAreaId   运营区域Id
     * @param developerId       开发商Id
     * @param parentId          上级运营区域Id
     * @param operationAreaName 开发商别名
     */
    void saveOrUpdateDeveloperOperationArea(Long operationAreaId, Long developerId, Long parentId, String operationAreaName);
}