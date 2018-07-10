package com.home.system.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.dto.RoleDto;
import com.home.system.common.vo.AdminVo;
import com.home.system.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员 相关接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@RestController
@RequestMapping("/admin")
public class AdminRest {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResultVo<AdminVo> findDeveloper(@RequestParam(name = "primaryKey") Long primaryKey) {
        return adminService.findAdminByPrimaryKey(primaryKey);
    }

    @PostMapping("/role")
    public ResultVo saveRole(@RequestBody RoleDto param) {
        System.out.println("PostMapping");
        System.out.println(param);
        return ResultVo.ok();
    }

    @PutMapping("/role")
    public ResultVo putRole(@RequestBody RoleDto param) {
        System.out.println("PutMapping");
        System.out.println(param);
        return ResultVo.ok();
    }

    @DeleteMapping("/role")
    public ResultVo deleteRole(@RequestParam(name = "primaryKey") Long primaryKey) {
        System.out.println("DeleteMapping");
        System.out.println(primaryKey);
        return ResultVo.ok();
    }
}
