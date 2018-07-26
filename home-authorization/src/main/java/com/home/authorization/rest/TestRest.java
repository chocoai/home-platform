package com.home.authorization.rest;

import com.home.common.core.vo.ResultVo;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-11 15:36
 **/
@RestController
@RequestMapping("/test")
public class TestRest {

    /**
     * 获取当前登陆用户信息
     */
    @RequestMapping("/user")
    public ResultVo user(){
        return ResultVo.ok("sdfsdfsdfds123456");
    }
}
