package com.home.customer.server.service.impl;

import com.home.customer.common.vo.CustomerVo;
import com.home.customer.server.entity.Customer;
import com.home.customer.server.repository.CustomerRepository;
import com.home.customer.server.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 客户表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-6-11 19:02:32
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerVo findCustomerByPrimaryKey(Long primaryKey) {
        Optional<Customer> customerOptional = customerRepository.findById(primaryKey);
        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            CustomerVo customerVo = new CustomerVo();
            BeanUtils.copyProperties(customer,customerVo);
            return customerVo;
        }else {
            return null;
        }
    }
}