package com.home.employee.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工来源信息表 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Data
@Entity
@Table(name = "home_employee_source")
public class EmployeeSource {

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
	 * 分销商Id
	 */
	private Long distributionId;

    /**
     * 员工Id
     */
	private Long employeeId;

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