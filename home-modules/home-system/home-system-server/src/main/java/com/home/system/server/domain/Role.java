package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 角色名
     */
	private String roleName;

    /**
     * 备注
     */
	private String remark;

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