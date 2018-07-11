package com.home.system.server.service.impl;

import com.home.system.server.domain.Dictionary;
import com.home.system.server.repository.DictionaryRepository;
import com.home.system.server.service.DictionaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字典信息 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryRepository dictionaryRepository;

}