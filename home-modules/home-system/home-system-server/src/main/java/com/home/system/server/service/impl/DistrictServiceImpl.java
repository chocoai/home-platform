package com.home.system.server.service.impl;

import com.home.system.server.domain.District;
import com.home.system.server.repository.DistrictRepository;
import com.home.system.server.service.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 区域 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    private DistrictRepository districtRepository;

}