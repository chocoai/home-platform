package com.home.system.common.vo;

import lombok.Data;

import java.util.Date;

/**
 * 角色 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
public class RoleVo {

	/**
	 * 主键id
	 */
	private Long id;

    /**
     * 角色名
     */
	private String roleName;

    /**
     * 备注
     */
	private String remark;

}