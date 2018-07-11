package com.home.system.server.service.impl;

import com.home.system.server.domain.AdminLog;
import com.home.system.server.repository.AdminLogRepository;
import com.home.system.server.service.AdminLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员登录日志 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AdminLogServiceImpl implements AdminLogService{

    @Autowired
    private AdminLogRepository adminLogRepository;

}