package com.home.system.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 城市 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Data
@Entity
@Table(name = "sys_city")
public class City {

	/**
	 * 主键id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * 城市代码
     */
	private String code;

    /**
     * 城市名称
     */
	private String name;

    /**
     * 省份ID
     */
	private Long provinceId;
}