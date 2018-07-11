package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 权限 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_authorization")
public class Authorization {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 权限名称
     */
	private String name;

    /**
     * 上级权限Id
     */
	private Long parentId;

    /**
     * 别名
     */
	private String alias;

    /**
     * 终端类型(0-PC端,1-Mobile端)
     */
	private Boolean terminalType;

    /**
     * 权限类型(0-page,1-element)
     */
	private Boolean type;

    /**
     * 序号
     */
	private Integer sort;

    /**
     * 图标
     */
	private String authIcon;

    /**
     * 所属模块
     */
	private String module;

    /**
     * 跳转目标
     */
	private String target;

    /**
     * 资源级别(1 一级/2 二级/3 三级)
     */
	private Integer level;

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