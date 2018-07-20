package com.home.system.common.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单栏响应数据
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-19 13:36
 **/
@Data
public class ItemVo {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单路由地址
     */
    private String index;
    /**
     * 子菜单
     */
    private List<ItemVo> subs = null;
}
