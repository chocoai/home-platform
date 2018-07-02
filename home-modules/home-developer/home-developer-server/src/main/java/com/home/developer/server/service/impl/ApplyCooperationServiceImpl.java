package com.home.developer.server.service.impl;

import com.home.developer.server.domain.ApplyCooperation;
import com.home.developer.server.repository.ApplyCooperationRepository;
import com.home.developer.server.service.ApplyCooperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分销商申请合作 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class ApplyCooperationServiceImpl implements ApplyCooperationService{

    @Autowired
    private ApplyCooperationRepository applyCooperationRepository;

}