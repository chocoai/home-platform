package com.home.system.common.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 管理员Vo
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-09 18:54
 **/
@Data
public class AdminVo {
    /**
     * 主键id
     */
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

    private List<RoleVo> roleVoList = new ArrayList<>();
}
