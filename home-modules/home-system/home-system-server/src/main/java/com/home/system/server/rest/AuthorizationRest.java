package com.home.system.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import com.home.system.server.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-18 13:35
 **/
@RestController
@RequestMapping("/authorization")
public class AuthorizationRest {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(@RequestParam(name = "roleName") String roleName){
        return authorizationService.findAuthorizationByRole(roleName);
    }

}
