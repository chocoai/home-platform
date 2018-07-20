package com.home.system.server.service.impl;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.RoleVo;
import com.home.system.server.domain.Role;
import com.home.system.server.repository.RoleRepository;
import com.home.system.server.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleVo> findRoleByAdminId(Long adminId) {
        List<Role> roles = roleRepository.findByAdminId(adminId);
        if (CollectionUtils.isEmpty(roles)){
            return null;
        }
        List<RoleVo> roleVos = new ArrayList<>();
        RoleVo roleVo = null;
        for (Role role : roles){
            roleVo = new RoleVo();
            roleVo.setId(role.getId());
            roleVo.setRoleName(role.getRoleName());
            roleVo.setRemark(role.getRemark());
            roleVos.add(roleVo);
        }
        return roleVos;
    }

    @Override
    public ResultVo<List<RoleVo>> findAll() {
        List<Role> roleList =  roleRepository.findByDeleteFlag(false);
        if(CollectionUtils.isEmpty(roleList)){
            return ResultVo.dataEmpty();
        }

        List<RoleVo> roleVos = roleList.stream()
                .map(role -> {
                    RoleVo roleVo = new RoleVo();
                    roleVo.setId(role.getId());
                    roleVo.setRoleName(role.getRoleName());
                    roleVo.setRemark(role.getRemark());
                    return roleVo;
                }).collect(Collectors.toList());
        return ResultVo.ok(roleVos);
    }

    @Override
    public ResultVo<List<Long>> findHasRoleByAccount(String account) {
        List<Long> longs = roleRepository.findHasRoleByAccount(account);
        return ResultVo.ok(longs);
    }
}