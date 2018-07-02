package com.home.developer.server.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 楼盘表 实体类
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Data
@Entity
@Table(name = "home_building")
public class Building {

	/**
	 * 主键Id
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
     * 楼盘名称
     */
	private String buildingName;

    /**
     * 管理公司名称
     */
	private String managementCompanyName;

    /**
     * 负责人
     */
	private String chargerName;

    /**
     * 负责人联系电话
     */
	private String chargerMobile;

    /**
     * 国家Id
     */
	private Long countryId;

    /**
     * 国家
     */
	private String country;

    /**
     * 省Id
     */
	private Long provinceId;

    /**
     * 省
     */
	private String province;

    /**
     * 市Id
     */
	private Long cityId;

    /**
     * 市
     */
	private String city;

    /**
     * 区Id
     */
	private Long districtId;

    /**
     * 区
     */
	private String district;

    /**
     * 详细地址
     */
	private String address;

    /**
     * 经度
     */
	private Double longitude;

    /**
     * 纬度
     */
	private Double latitude;

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