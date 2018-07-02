package com.home.employee.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工信息表 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Data
@Entity
@Table(name = "home_employee")
public class Employee {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 姓名
     */
	private String staffName;

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
     * 密码
     */
	private String employeePassword;

    /**
     * 婚姻状况 0-未婚,1-已婚
     */
	private Boolean maritalStatus;

    /**
     * 实名认证状态 0-未认证,1-已认证
     */
	private Boolean certificationStatus;

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