package com.home.system.server.service.impl;

import com.home.system.server.domain.AdminRole;
import com.home.system.server.repository.AdminRoleRepository;
import com.home.system.server.service.AdminRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 管理员角色关联 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleRepository adminRoleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void adminAssignRole(Long adminId, Long... roleIds) {
        AdminRole adminRole = null;
        for (Long roleId : roleIds) {
            int count = adminRoleRepository.countAdminRoleByAdminIdAndRoleIdAndDeleteFlag(adminId, roleId, false);
            if (count == 0) {
                adminRole = new AdminRole();
                adminRole.setAdminId(adminId);
                adminRole.setRoleId(roleId);
                adminRole.setCreateTime(new Date());
                adminRole.setUpdateTime(adminRole.getCreateTime());
                adminRole.setDeleteFlag(Boolean.FALSE);
                adminRoleRepository.save(adminRole);
            }
        }

    }
}