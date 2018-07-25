package com.home.system.server.rest;

import com.home.common.core.dto.DeleteDto;
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

import javax.xml.transform.Result;

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

    @PostMapping
    public ResultVo save(@RequestBody AdminVo adminVo){
        adminService.save(adminVo);
        return ResultVo.ok();
    }

    @PutMapping
    public ResultVo modify(@RequestBody AdminVo adminVo){
        adminService.modify(adminVo);
        return ResultVo.ok();
    }

    @PostMapping("delete")
    public ResultVo delete(@RequestBody DeleteDto param){
        adminService.deleteAdmin(param.getIds());
        return ResultVo.ok();
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
