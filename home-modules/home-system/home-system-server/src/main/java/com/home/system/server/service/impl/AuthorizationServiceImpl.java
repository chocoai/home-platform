package com.home.system.server.service.impl;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import com.home.system.common.vo.ItemVo;
import com.home.system.server.domain.Authorization;
import com.home.system.server.repository.AuthorizationRepository;
import com.home.system.server.service.AuthorizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 权限 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Override
    public ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(String roleName) {
        List<Authorization> authorizations = authorizationRepository.findByRoleName(roleName);
        if (CollectionUtils.isEmpty(authorizations)) {
            return ResultVo.dataEmpty();
        }

        Set<AuthorizationVo> authorizationVos = new HashSet<>();
        AuthorizationVo authorizationVo = null;
        for (Authorization authorization : authorizations) {
            authorizationVo = new AuthorizationVo();
            BeanUtils.copyProperties(authorization, authorizationVo);
            authorizationVos.add(authorizationVo);
        }
        return ResultVo.ok(authorizationVos);
    }

    /**
     *
     * @param parent
     * @param account
     */
    public void findAuthorizationByAccountAndParentId(List<ItemVo>  parent, String account) {
        for (ItemVo itemVo : parent) {
            List<Authorization> child = authorizationRepository.findByAccountAndParentId(account, itemVo.getId());
            if (!CollectionUtils.isEmpty(child)){
                List<ItemVo> subs = this.transform(child);
                itemVo.setSubs(subs);
                findAuthorizationByAccountAndParentId(subs,account);
            }
        }
    }

    @Override
    public ResultVo<List<ItemVo>> findAuthorizationByAccount(String account) {
        // 获取第一级权限
        List<Authorization> child = authorizationRepository.findByAccountAndParentId(account, 0L);
        List<ItemVo> itemVoList = this.transform(child);

        findAuthorizationByAccountAndParentId(itemVoList,account);
        return ResultVo.ok(itemVoList);
    }

    private List<ItemVo> transform(List<Authorization> authorizations) {
        if (CollectionUtils.isEmpty(authorizations)) {
            return new ArrayList<>();
        } else {
            return authorizations.stream().map(authorization -> {
                ItemVo itemVo = new ItemVo();
                itemVo.setIcon(authorization.getAuthIcon());
                itemVo.setId(authorization.getId());
                itemVo.setIndex(authorization.getTarget());
                itemVo.setTitle(authorization.getName());
                return itemVo;
            }).collect(Collectors.toList());
        }
    }
}