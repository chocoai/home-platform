package com.home.system.server.service.impl;

import com.home.system.server.domain.Province;
import com.home.system.server.repository.ProvinceRepository;
import com.home.system.server.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 省份 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    private ProvinceRepository provinceRepository;

}