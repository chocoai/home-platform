package com.home.developer.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.DeveloperDto;
import com.home.developer.server.domain.Developer;
import com.home.developer.server.domain.DeveloperOperationAccount;
import com.home.developer.server.domain.DeveloperOperationArea;
import com.home.developer.server.repository.DeveloperRepository;
import com.home.developer.server.service.DeveloperOperationAccountService;
import com.home.developer.server.service.DeveloperOperationAreaService;
import com.home.developer.server.service.DeveloperService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * 开发商 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private DeveloperOperationAreaService developerOperationAreaService;
    @Autowired
    private DeveloperOperationAccountService developerOperationAccountService;

    @Override
    @Transactional(rollbackFor = {HomeCustomException.class,Exception.class})
    public void saveOrUpdate(DeveloperDto param) {
        if (null == param.getId()) {
            // 添加
            Developer save = new Developer();
            BeanUtils.copyProperties(param, save);
            save.setCreateTime(new Date());
            save.setUpdateTime(save.getCreateTime());
            save.setDeleteFlag(false);
            Developer developer = developerRepository.save(save);
            if (null == developer.getId()) {
                throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER.getCode(), DeveloperExceptionCode.SAVE_DEVELOPER.getMessage());
            }

            // 添加开发商默认运营区域
            DeveloperOperationArea developerOperationArea = developerOperationAreaService.saveDefaultDeveloperOperationArea(developer.getId(), developer.getDeveloperAlias());

            // 添加开发商默认管理账号
            developerOperationAccountService.saveDefaultDeveloperOperationAccount(developer.getId(), developerOperationArea.getId(), developer.getDeveloperAlias());
        } else {
            // 修改
            // TODO 开发商修改
        }
    }

    @Override
    public ResultVo<DeveloperDto> findDeveloperByPrimaryKey(Long primaryKey) {
        Optional<Developer> developerOptional = developerRepository.findById(primaryKey);
        if (developerOptional.isPresent()) {
            Developer developer = developerOptional.get();
            DeveloperDto developerDto = new DeveloperDto();
            BeanUtils.copyProperties(developer, developerDto);
            return ResultVo.ok(developerDto);
        }
        return ResultVo.dataEmpty();
    }
}