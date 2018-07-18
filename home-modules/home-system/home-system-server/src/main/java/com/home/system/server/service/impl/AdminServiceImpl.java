package com.home.system.server.service.impl;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AdminVo;
import com.home.system.common.vo.RoleVo;
import com.home.system.server.domain.Admin;
import com.home.system.server.repository.AdminRepository;
import com.home.system.server.service.AdminService;

import com.home.system.server.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 管理员 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public ResultVo<AdminVo> findAdminByPrimaryKey(Long primaryKey) {
        Optional<Admin> adminOptional = adminRepository.findById(primaryKey);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            AdminVo adminVo = new AdminVo();
            BeanUtils.copyProperties(admin, adminVo);
            return ResultVo.ok(adminVo);
        }
        return ResultVo.dataEmpty();
    }

    @Override
    public ResultVo<AdminVo> findAdminByAccount(String account) {
        Admin admin = adminRepository.findAdminByAccount(account);
        if (null == admin) {
            return ResultVo.dataEmpty();
        }
        AdminVo adminVo = new AdminVo();
        BeanUtils.copyProperties(admin, adminVo);

        List<RoleVo> roleVos = roleService.findRoleByAdminId(admin.getId());
        adminVo.setRoleVoList(roleVos);
        return ResultVo.ok(adminVo);
    }
}