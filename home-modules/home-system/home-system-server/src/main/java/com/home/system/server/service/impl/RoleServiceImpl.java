package com.home.system.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.system.SystemExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.RoleVo;
import com.home.system.server.domain.Role;
import com.home.system.server.repository.RoleRepository;
import com.home.system.server.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    @Override
    public void role(RoleVo param) {
        if (null == param.getId()){
            // 添加
            Role role = new Role();
            role.setRoleName(param.getRoleName());
            role.setRemark(param.getRemark());
            role.setCreateTime(new Date());
            role.setUpdateTime(role.getCreateTime());
            role.setDeleteFlag(Boolean.FALSE);

            roleRepository.save(role);
        }else {
            // 修改
            Optional<Role> roleOptional = roleRepository.findById(param.getId());
            if (!roleOptional.isPresent()){
                throw new HomeCustomException(SystemExceptionCode.ROLE_NON_EXISTENT.getCode(),SystemExceptionCode.ROLE_NON_EXISTENT.getMessage());
            }
            Role role = roleOptional.get();
            role.setRemark(param.getRemark());
            role.setRoleName(param.getRoleName());
            role.setUpdateTime(new Date());

            roleRepository.save(role);
        }
    }

    @Override
    public void deleteRole(Long... primaryKeys) {
        List<Role> roles = new ArrayList<>();
        Role role = null;
        for (Long primaryKey : primaryKeys) {
            Optional<Role> roleOptional = roleRepository.findById(primaryKey);
            if (!roleOptional.isPresent()){
                throw new HomeCustomException(SystemExceptionCode.ROLE_NON_EXISTENT.getCode(),SystemExceptionCode.ROLE_NON_EXISTENT.getMessage());
            }
            role = roleOptional.get();
            role.setUpdateTime(new Date());
            role.setDeleteFlag(Boolean.TRUE);
            roles.add(role);
        }
        roleRepository.saveAll(roles);
    }

    @Override
    public RoleVo findRoleById(Long primaryKey) {
        Optional<Role> roleOptional = roleRepository.findById(primaryKey);
        if (roleOptional.isPresent()){
            Role role = roleOptional.get();
            RoleVo roleVo = new RoleVo();
            roleVo.setId(role.getId());
            roleVo.setRoleName(role.getRoleName());
            roleVo.setRemark(role.getRemark());
            return roleVo;
        }
        throw new HomeCustomException(SystemExceptionCode.ROLE_NON_EXISTENT.getCode(),SystemExceptionCode.ROLE_NON_EXISTENT.getMessage());
    }
}