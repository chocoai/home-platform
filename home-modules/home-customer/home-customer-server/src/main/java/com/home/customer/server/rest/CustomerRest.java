package com.home.customer.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.customer.common.vo.CustomerVo;
import com.home.customer.server.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 11:16
 **/
@Api(tags = {"客户相关操作"})
@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    @ApiOperation(value = "获取客户详情", notes = "根据客户Id获取客户详情")
    public ResultVo<CustomerVo> getCustomer(@ApiParam(name = "customerId", value = "客户Id", required = true) @PathVariable(name = "customerId") Long customerId){
        CustomerVo customerVo = customerService.findCustomerByPrimaryKey(customerId);
        return ResultVo.ok(customerVo);
    }

}
