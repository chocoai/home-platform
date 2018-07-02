package com.home.developer.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.developer.server.domain.DeveloperOperationArea;
import com.home.developer.server.repository.DeveloperOperationAreaRepository;
import com.home.developer.server.service.DeveloperOperationAreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 开发商运营区域 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class DeveloperOperationAreaServiceImpl implements DeveloperOperationAreaService{

    @Autowired
    private DeveloperOperationAreaRepository developerOperationAreaRepository;

    @Override
    public DeveloperOperationArea saveDefaultDeveloperOperationArea(Long developerId, String operationAreaName) {
        DeveloperOperationArea save = new DeveloperOperationArea();
        save.setOperationAreaName(operationAreaName);
        save.setDeveloperId(developerId);
        save.setParentId(0L);
        save.setDirectBuildings(0);
        save.setCreateTime(new Date());
        save.setUpdateTime(save.getCreateTime());
        save.setDeleteFlag(false);

        DeveloperOperationArea developerOperationArea = developerOperationAreaRepository.save(save);
        if (null == developerOperationArea || null == developerOperationArea.getId()){
            throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER_DEFAULT_OPERATION_AREA.getCode(),DeveloperExceptionCode.SAVE_DEVELOPER_DEFAULT_OPERATION_AREA.getMessage());
        }
        return developerOperationArea;
    }

    @Override
    public void saveOrUpdateDeveloperOperationArea(Long operationAreaId,Long developerId, Long parentId, String operationAreaName) {
        if (null == operationAreaId){
            // 添加
            DeveloperOperationArea save = new DeveloperOperationArea();
            save.setOperationAreaName(operationAreaName);
            save.setDeveloperId(developerId);
            save.setParentId(parentId);
            save.setDirectBuildings(0);
            save.setCreateTime(new Date());
            save.setUpdateTime(save.getCreateTime());
            save.setDeleteFlag(false);

            DeveloperOperationArea developerOperationArea = developerOperationAreaRepository.save(save);
            if (null == developerOperationArea || null == developerOperationArea.getId()){
                throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER_OPERATION_AREA.getCode(),DeveloperExceptionCode.SAVE_DEVELOPER_OPERATION_AREA.getMessage());
            }
        }else {
            // 修改
            // TODO 开发商运营区域修改
        }
    }
}