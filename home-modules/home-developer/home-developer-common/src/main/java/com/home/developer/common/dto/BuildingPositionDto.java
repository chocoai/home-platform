package com.home.developer.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * 楼盘职位 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Data
public class BuildingPositionDto {

	/**
	 * 主键id
	 */
	private Long id;

    /**
     * 开发商Id
     */
	private Long developerId;

    /**
     * 开发商运营区域Id
     */
	private Long operationAreaId;

    /**
     * 楼盘Id
     */
	private Long buildingId;

    /**
     * 父级职位Id
     */
	private Long parentId;

    /**
     * 职位名称
     */
	private String positionName;

    /**
     * 职位别名
     */
	private String positionAlias;
}