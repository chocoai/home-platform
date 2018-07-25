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
    @GetMapping
    public ResultVo<List<RoleVo>> findRole() {
        return roleService.findAll();
    }

    @GetMapping("/{primaryKey}")
    public ResultVo<RoleVo> findRole(@PathVariable Long primaryKey) {
        RoleVo roleVo = roleService.findRoleById(primaryKey);
        return ResultVo.ok(roleVo);
    }

    @PostMapping
    public ResultVo save(@RequestBody RoleVo param) {
        roleService.role(param);
        return ResultVo.ok();
    }

    @PutMapping
    public ResultVo modify(@RequestBody RoleVo param) {
        roleService.role(param);
        return ResultVo.ok();
    }

    @DeleteMapping()
    public ResultVo deleteRole(@RequestParam Long primaryKey) {
        roleService.deleteRole(primaryKey);
        return ResultVo.ok();
    }

    /**
     * 获取账号已分配的角色
     */
    @GetMapping("/has")
    public ResultVo<List<Long>> findHasRole(@RequestParam String account) {
        return roleService.findHasRoleByAccount(account);
    }
}
