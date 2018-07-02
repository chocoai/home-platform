package com.home.developer.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 10:15
 **/
@Data
public class DeveloperDto {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 公司代码
     */
    private String developerCode;

    /**
     * 公司名称
     */
    private String developerName;

    /**
     * 公司别名
     */
    private String developerAlias;

    /**
     * 法人代表
     */
    private String presidentName;

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
     * 工商注册详细地址
     */
    private String registerAddress;

    /**
     * 该开发商创建楼盘上限
     */
    private Integer createBuildingLimit;

    /**
     * 有效期标志(0-永久有效,1-在时间范围内有效)
     */
    private Boolean validateType;

    /**
     * 有效期开始时间
     */
    private Date validateBeginDate;

    /**
     * 有效期结束时间
     */
    private Date validateEndDate;
}
