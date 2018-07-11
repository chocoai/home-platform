package com.home.system.server.service.impl;

import com.home.system.server.domain.RoleAuthorization;
import com.home.system.server.repository.RoleAuthorizationRepository;
import com.home.system.server.service.RoleAuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色权限关联 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class RoleAuthorizationServiceImpl implements RoleAuthorizationService{

    @Autowired
    private RoleAuthorizationRepository roleAuthorizationRepository;

}