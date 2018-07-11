package com.home.system.server.service.impl;

import com.home.system.server.domain.Authorization;
import com.home.system.server.repository.AuthorizationRepository;
import com.home.system.server.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{

    @Autowired
    private AuthorizationRepository authorizationRepository;

}