package com.home.system.server.service.impl;

import com.home.system.server.domain.City;
import com.home.system.server.repository.CityRepository;
import com.home.system.server.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

}