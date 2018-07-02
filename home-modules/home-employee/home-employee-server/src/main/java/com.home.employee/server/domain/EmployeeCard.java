package com.home.employee.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工证件信息表 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Data
@Entity
@Table(name = "home_employee_card")
public class EmployeeCard {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 员工Id
     */
	private Long employeeId;

    /**
     * 证件号码
     */
	private String cardNumber;

    /**
     * 证件地址
     */
	private String cardAddress;

    /**
     * 姓名
     */
	private String cardName;

    /**
     * 性别(0-男、1-女)
     */
	private Boolean gender;

    /**
     * 出生日期
     */
	private Date birthday;

    /**
     * 证件头像
     */
	private String cardImage;

    /**
     * 身份证正面照
     */
	private String cardFrontImage;

    /**
     * 身份证反面面照
     */
	private String cardBackImage;

    /**
     * 手持身份证照
     */
	private String cardFaceImage;

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