package com.home.developer.server.service;

import com.home.developer.server.domain.DeveloperOperationAccount;

/**
 * 开发商运营区域管理账号 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface DeveloperOperationAccountService {

    /**
     * 添加开发商 默认管理账号
     *
     * @param developerId     开发商Id
     * @param operationAreaId 开发商运营区域Id
     * @param developerAlias  开发商别名
     * @return DeveloperOperationAccount
     */
    DeveloperOperationAccount saveDefaultDeveloperOperationAccount(Long developerId, Long operationAreaId, String developerAlias);

    /**
     * 添加开发商 管理账号
     *
     * @param operationAccountId 运营账号Id
     * @param developerId        开发商Id
     * @param operationAreaId    开发商运营区域Id
     * @param account            账号
     * @param password           密码
     */
    void saveOrUpdateDeveloperOperationAccount(Long operationAccountId, Long developerId, Long operationAreaId, String account, String password);
}