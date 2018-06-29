package com.home.customer.server.service;

import com.home.customer.common.vo.CustomerVo;
import com.home.customer.server.entity.Customer;

/**
 * 客户表 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-6-11 19:02:32
*/
public interface CustomerService{

    /**
     * 根据主键获取客户信息
     * @param primaryKey 主键
     * @return Customer
     */
    CustomerVo findCustomerByPrimaryKey(Long primaryKey);
}