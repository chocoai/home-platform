package com.home.developer.server.service.impl;

import com.home.developer.server.domain.ApplyCooperationRecord;
import com.home.developer.server.repository.ApplyCooperationRecordRepository;
import com.home.developer.server.service.ApplyCooperationRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分销商申请合作审核记录 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class ApplyCooperationRecordServiceImpl implements ApplyCooperationRecordService{

    @Autowired
    private ApplyCooperationRecordRepository applyCooperationRecordRepository;

}