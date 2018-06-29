package com.home.customer.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Customer 视图对象
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 14:32
 **/
@Data
@ApiModel(value = "Customer响应")
public class CustomerVo {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String customerName;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String headImage;
    /**
     * 性别性别(0-男、1-女)
     */
    @ApiModelProperty(value = "性别性别(0-男、1-女)")
    private Boolean gender;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
}
