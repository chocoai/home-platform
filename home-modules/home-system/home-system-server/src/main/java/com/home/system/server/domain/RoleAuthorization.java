package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色权限关联 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_role_authorization")
public class RoleAuthorization {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 管理员Id
     */
	private Long adminId;

    /**
     * 权限Id
     */
	private Long authorizationId;

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