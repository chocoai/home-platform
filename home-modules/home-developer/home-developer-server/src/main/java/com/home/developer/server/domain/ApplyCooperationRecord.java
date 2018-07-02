package com.home.developer.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 分销商申请合作审核记录 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Data
@Entity
@Table(name = "home_apply_cooperation_record")
public class ApplyCooperationRecord {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 开发商Id
     */
	private Long applyCooperationId;

    /**
     * 备注
     */
	private String remark;

    /**
     * 操作人员 员工楼盘岗位Id
     */
	private Long employeeBuildingPositionId;

    /**
     * 操作人员 员工Id
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