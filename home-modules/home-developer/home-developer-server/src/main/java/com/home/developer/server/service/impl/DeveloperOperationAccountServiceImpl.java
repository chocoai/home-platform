package com.home.developer.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.util.PinYinUtil;
import com.home.developer.server.constant.DeveloperConstant;
import com.home.developer.server.domain.Developer;
import com.home.developer.server.domain.DeveloperOperationAccount;
import com.home.developer.server.repository.DeveloperOperationAccountRepository;
import com.home.developer.server.repository.DeveloperRepository;
import com.home.developer.server.service.DeveloperOperationAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * 开发商运营区域管理账号 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
@Service
public class DeveloperOperationAccountServiceImpl implements DeveloperOperationAccountService {

    @Autowired
    private DeveloperOperationAccountRepository developerOperationAccountRepository;
    @Autowired
    private DeveloperRepository developerRepository;


    @Override
    public DeveloperOperationAccount saveDefaultDeveloperOperationAccount(Long developerId, Long operationAreaId, String developerAlias) {
        DeveloperOperationAccount save = new DeveloperOperationAccount();
        save.setDeveloperId(developerId);
        save.setOperationAreaId(operationAreaId);

        // 构建账号
        // 获取拼音首字母
        String firstSpell = PinYinUtil.getFirstSpell(developerAlias);
        String account = firstSpell + DeveloperConstant.DEFAULT_FIRST_DEVELOPER_OPERATION_ACCOUNT_SUFFIX;
        save.setAccount(account);

        // 构建密码
        // TODO 添加开发商默认账号密码加密
        String password = firstSpell + DeveloperConstant.DEFAULT_FIRST_DEVELOPER_OPERATION_ACCOUNT_PASSWORD_SUFFIX;
        save.setPassword(password);

        save.setCreateTime(new Date());
        save.setUpdateTime(save.getCreateTime());
        save.setDeleteFlag(false);

        DeveloperOperationAccount developerOperationAccount = developerOperationAccountRepository.save(save);
        if (null == developerOperationAccount || null == developerOperationAccount.getId()) {
            throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER_DEFAULT_ACCOUNT.getCode(), DeveloperExceptionCode.SAVE_DEVELOPER_DEFAULT_ACCOUNT.getMessage());
        }
        return developerOperationAccount;
    }

    @Override
    public void saveOrUpdateDeveloperOperationAccount(Long operationAccountId, Long developerId, Long operationAreaId, String accountSuffix, String password) {
        if (null == operationAccountId) {
            // 添加
            DeveloperOperationAccount save = new DeveloperOperationAccount();
            save.setDeveloperId(developerId);
            save.setOperationAreaId(operationAreaId);

            // 构建账号
            // 获取开发商
            Optional<Developer> developerOptional = developerRepository.findById(developerId);
            if (!developerOptional.isPresent()) {
                throw new HomeCustomException(DeveloperExceptionCode.DEVELOPER_UN_EXISTED.getCode(), DeveloperExceptionCode.DEVELOPER_UN_EXISTED.getMessage());
            }
            Developer developer = developerOptional.get();
            // 获取拼音首字母
            String firstSpell = PinYinUtil.getFirstSpell(developer.getDeveloperAlias());
            String account = firstSpell + accountSuffix;
            save.setAccount(account);

            // 构建密码
            // TODO 添加开发商账号密码加密
            save.setPassword(password);

            save.setCreateTime(new Date());
            save.setUpdateTime(save.getCreateTime());
            save.setDeleteFlag(false);

            DeveloperOperationAccount developerOperationAccount = developerOperationAccountRepository.save(save);
            if (null == developerOperationAccount || null == developerOperationAccount.getId()) {
                throw new HomeCustomException(DeveloperExceptionCode.SAVE_DEVELOPER_ACCOUNT.getCode(), DeveloperExceptionCode.SAVE_DEVELOPER_ACCOUNT.getMessage());
            }
        } else {
            // 修改
            // TODO 修改运营管理账号
        }
    }
}