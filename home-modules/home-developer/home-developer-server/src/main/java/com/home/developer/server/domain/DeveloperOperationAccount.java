package com.home.developer.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 开发商运营区域管理账号 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Data
@Entity
@Table(name = "home_developer_operation_account")
public class DeveloperOperationAccount {

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
     * 账号名称
     */
	private String account;

    /**
     * 密码
     */
	private String password;

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