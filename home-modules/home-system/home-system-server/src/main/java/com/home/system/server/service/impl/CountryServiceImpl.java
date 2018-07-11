package com.home.system.server.service.impl;

import com.home.system.server.domain.Country;
import com.home.system.server.repository.CountryRepository;
import com.home.system.server.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 国家 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

}