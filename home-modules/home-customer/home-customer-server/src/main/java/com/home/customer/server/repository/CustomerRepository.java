package com.home.customer.server.repository;

import com.home.customer.server.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 客户表
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-6-11 18:36:10
*/
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}