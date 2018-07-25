package com.home.system.server.rest;

import com.home.common.core.dto.DeleteDto;
import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import com.home.system.common.vo.ItemVo;
import com.home.system.common.vo.RoleAuthorizationVo;
import com.home.system.server.service.AuthorizationService;
import com.home.system.server.service.RoleAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private RoleAuthorizationService roleAuthorizationService;

    @GetMapping("/{primaryKey}")
    public ResultVo<AuthorizationVo> findAuthorizationByPrimaryKey(@PathVariable Long primaryKey) {
        return authorizationService.findAuthorizationByPrimaryKey(primaryKey);
    }

    /**
     * 获取权限
     *
     * @param parentId     父节点Id
     * @param terminalType 终端类型(0-PC端,1-Mobile端)
     * @param childType    获取子节点类型(0-所有子节点,1-直属子节点)
     */
    @GetMapping
    public ResultVo<List<AuthorizationVo>> findAuthorizationByPrimaryKey(@RequestParam(name = "parentId") Long parentId,
                                                                         @RequestParam(name = "terminalType") int terminalType,
                                                                         @RequestParam(name = "childType") int childType) {
        return authorizationService.findAuthorizationByParentIdAndTerminalType(parentId, terminalType, childType);
    }

    @PostMapping
    public ResultVo save(@RequestBody AuthorizationVo param) {
        authorizationService.authorization(param);
        return ResultVo.ok();
    }

    @PutMapping
    public ResultVo modify(@RequestBody AuthorizationVo param) {
        authorizationService.authorization(param);
        return ResultVo.ok();
    }

    @DeleteMapping
    public ResultVo delete(@RequestParam Long primaryKey) {
        authorizationService.delete(primaryKey);
        return ResultVo.ok();
    }

    /**
     * 根据角色获取已经分配的权限
     */
    @GetMapping("/has")
    public ResultVo<Set<Long>> findHasAuthorizationByRoleId(@RequestParam(name = "roleId") Long roleId) {
        Set<Long> data = roleAuthorizationService.findHasAuthorizationByRoleId(roleId);
        return ResultVo.ok(data);
    }

    /**
     * 角色分配权限
     */
    @PostMapping("/assign")
    public ResultVo roleAssignAuthorization(@RequestBody RoleAuthorizationVo param) {
        authorizationService.roleAssignAuthorization(param.getRoleId(), param.getAuthorizationIds());
        return ResultVo.ok();
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(@RequestParam(name = "roleName") String roleName) {
        return authorizationService.findAuthorizationByRole(roleName);
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResultVo<List<ItemVo>> findAuthorizationByAccount(@RequestParam(name = "account") String account) {
        return authorizationService.findAuthorizationByAccount(account);
    }


}
