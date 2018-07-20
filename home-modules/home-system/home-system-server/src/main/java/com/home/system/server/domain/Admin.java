package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 管理员 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_admin")
public class Admin {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 管理员姓名
     */
	private String adminName;

    /**
     * 电话
     */
	private String mobile;

    /**
     * 邮箱
     */
	private String email;

    /**
     * 头像
     */
	private String headImage;

    /**
     * 登录账号
     */
	private String account;

    /**
     * 密码
     */
	private String password;

	/**
	 * 生日
	 */
	private Date birthday;

    /**
     * 状态(0-未激活,1-正常,2-锁定,3-注销)
     */
	private Integer state;

    /**
     * 上一次登录时间
     */
	private Date lastLogin;

    /**
     * 登录次数
     */
	private Integer loginCount;

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