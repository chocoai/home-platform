package com.home.customer.client;

import com.home.common.core.vo.ResultVo;
import com.home.customer.common.vo.CustomerVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 客户相关接口client
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 14:44
 **/
@FeignClient(
        name = "customer",
        fallback = CustomerClient.CustomerClientFallback.class
)
public interface CustomerClient {

    /**
     * 根据客户Id获取客户详情
     *
     * @param customerId 客户Id
     * @return CustomerVo
     */
    @GetMapping("/{customerId}")
    ResultVo<CustomerVo> getCustomer(@PathVariable(name = "customerId") Long customerId);

    @Component
    class CustomerClientFallback implements CustomerClient {
        @Override
        public ResultVo<CustomerVo> getCustomer(Long customerId) {
            return ResultVo.hystrix();
        }
    }
}
