package com.home.system.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.dto.AdminRoleDto;
import com.home.system.common.dto.RoleDto;
import com.home.system.common.vo.AdminVo;
import com.home.system.server.service.AdminRoleService;
import com.home.system.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
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
    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping("{primaryKey}")
    public ResultVo<AdminVo> findAdmin(@PathVariable(name = "primaryKey") Long primaryKey) {
        return adminService.findAdminByPrimaryKey(primaryKey);
    }

    @GetMapping("/account")
    public ResultVo<AdminVo> findAdminByAccount(@RequestParam(name = "account") String account) {
        return adminService.findAdminByAccount(account);
    }

    @GetMapping("/page")
    public ResultVo<Page<AdminVo>> findAdminPage(@RequestParam(name = "page") Integer page,
                                                @RequestParam(name = "size") Integer size) {
        return adminService.page(page,size);
    }

    @PostMapping("/assign-role")
    public ResultVo adminAssignROle(@RequestBody AdminRoleDto param) {
        adminRoleService.adminAssignRole(param.getAdminId(),param.getRoleIds());
        return ResultVo.ok();
    }
}
