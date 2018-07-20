package com.home.system.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.RoleVo;
import com.home.system.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-20 10:21
 **/
@RestController
@RequestMapping("/role")
public class RoleRest {

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有角色
     */
    @GetMapping("/all")
    public ResultVo<List<RoleVo>> findRole() {
        return roleService.findAll();
    }

    /**
     * 获取账号已分配的角色
     */
    @GetMapping("/has")
    public ResultVo<List<Long>> findHasRole(@RequestParam String account) {
        return roleService.findHasRoleByAccount(account);
    }
}
