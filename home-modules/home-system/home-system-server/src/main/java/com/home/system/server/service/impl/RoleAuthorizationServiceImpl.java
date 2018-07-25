package com.home.system.server.service.impl;

import com.home.common.core.constant.HomeConstant;
import com.home.system.server.domain.RoleAuthorization;
import com.home.system.server.repository.RoleAuthorizationRepository;
import com.home.system.server.service.RoleAuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 角色权限关联 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class RoleAuthorizationServiceImpl implements RoleAuthorizationService {

    @Autowired
    private RoleAuthorizationRepository roleAuthorizationRepository;

    @Override
    public List<RoleAuthorization> findRoleAuthorizationByRoleId(Long roleId) {
        return roleAuthorizationRepository.findByRoleIdAndDeleteFlag(roleId, Boolean.FALSE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoleAuthorization(List<RoleAuthorization> param) {
        Date date = new Date();
        param.stream().forEach(roleAuthorization -> {
            roleAuthorization.setDeleteFlag(Boolean.TRUE);
            roleAuthorization.setUpdateTime(date);
        });
        roleAuthorizationRepository.saveAll(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRoleAuthorization(List<RoleAuthorization> param) {
        Date date = new Date();
        param.stream().forEach(roleAuthorization -> {
            roleAuthorization.setDeleteFlag(Boolean.FALSE);
            roleAuthorization.setUpdateTime(date);
            roleAuthorization.setCreateTime(date);
        });
        roleAuthorizationRepository.saveAll(param);
    }

    @Override
    public Set<Long> findHasAuthorizationByRoleId(Long roleId) {
        Set<Long> has = new HashSet<>();
        List<RoleAuthorization> roots = roleAuthorizationRepository.findHasAuthorizationByRoleId(roleId, HomeConstant.AUTHORIZATION_ROOT_ID);

        findHasAuthorizationByRoleIdAndParentId(roots, has);
        return has;
    }

    /**
     * 递归角色已经分配的子权限
     *
     * @param roots 上级节点数据
     * @param has   已有的权限Id集合
     */
    public void findHasAuthorizationByRoleIdAndParentId(List<RoleAuthorization> roots, Set<Long> has) {
        roots.stream().forEach(root -> {
            List<RoleAuthorization> children = roleAuthorizationRepository.findHasAuthorizationByRoleId(root.getRoleId(), root.getAuthorizationId());
            if (CollectionUtils.isEmpty(children)) {
                has.add(root.getAuthorizationId());
            } else {
                findHasAuthorizationByRoleIdAndParentId(children, has);
            }
        });

    }

}