package com.home.employee.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工开分销商职位表 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-6-29 16:05:46
 */
@Data
@Entity
@Table(name = "home_employee_distribution_position")
public class EmployeeDistributionPosition {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 分销商Id
     */
	private Long distributionId;

    /**
     * 分销商职位Id
     */
	private Long distributionPositionId;

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