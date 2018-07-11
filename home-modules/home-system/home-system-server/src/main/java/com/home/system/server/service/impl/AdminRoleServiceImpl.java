package com.home.system.server.service.impl;

import com.home.system.server.domain.AdminRole;
import com.home.system.server.repository.AdminRoleRepository;
import com.home.system.server.service.AdminRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员角色关联 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{

    @Autowired
    private AdminRoleRepository adminRoleRepository;

}