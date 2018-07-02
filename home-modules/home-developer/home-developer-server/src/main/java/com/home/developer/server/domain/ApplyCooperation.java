package com.home.developer.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 分销商申请合作 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Data
@Entity
@Table(name = "home_apply_cooperation")
public class ApplyCooperation {

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
     * 状态 1-等待审核,2-审核通过,3-审核拒绝,4-解除合作,4-重新合作
     */
	private Integer cooperationStatus;

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