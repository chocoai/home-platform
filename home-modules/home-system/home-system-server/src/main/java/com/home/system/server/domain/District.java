package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 区域 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_district")
public class District {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 区域代码
     */
	private String code;

    /**
     * 区域名称
     */
	private String name;

    /**
     * 城市ID
     */
	private Long cityId;
}