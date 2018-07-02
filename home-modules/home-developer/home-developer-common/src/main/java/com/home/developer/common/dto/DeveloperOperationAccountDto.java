package com.home.developer.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * 开发商运营区域管理账号
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Data
public class DeveloperOperationAccountDto {

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
     * 账号名称
     */
	private String account;

    /**
     * 密码
     */
	private String password;
}