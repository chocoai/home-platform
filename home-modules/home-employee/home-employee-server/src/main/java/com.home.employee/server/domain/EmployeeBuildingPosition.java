package com.home.employee.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工开发商楼盘职位表 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-6-29 16:05:46
 */
@Data
@Entity
@Table(name = "home_employee_building_position")
public class EmployeeBuildingPosition {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 楼盘职位Id
     */
	private Long buildingPositionId;

    /**
     * 员工Id
     */
	private Long employeeId;

    /**
     * 工作状态(0-在职,1-离职)
     */
	private Boolean workState;

    /**
     * 入职时间
     */
	private Date entryTime;

    /**
     * 离职时间
     */
	private Date dimissionTime;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date updateTime;

    /**
     * 删除标志 0-未删，1-删除
     */
	private Boolean deleteFlag;
}