package com.home.developer.common.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 14:08
 **/
@Data
public class DeveloperOperationAreaDto {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 开发商Id
     */
    private Long developerId;

    /**
     * 父级区域Id
     */
    private Long parentId;

    /**
     * 名称
     */
    private String operationAreaName;

    /**
     * 该区域直属楼盘数目
     */
    private Integer directBuildings;
}
