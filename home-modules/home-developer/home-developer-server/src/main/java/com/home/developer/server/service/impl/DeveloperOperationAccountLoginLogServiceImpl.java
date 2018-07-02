package com.home.developer.server.service.impl;

import com.home.developer.server.domain.DeveloperOperationAccountLoginLog;
import com.home.developer.server.repository.DeveloperOperationAccountLoginLogRepository;
import com.home.developer.server.service.DeveloperOperationAccountLoginLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 开发商运营区域管理账号登陆日志 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class DeveloperOperationAccountLoginLogServiceImpl implements DeveloperOperationAccountLoginLogService{

    @Autowired
    private DeveloperOperationAccountLoginLogRepository developerOperationAccountLoginLogRepository;

}