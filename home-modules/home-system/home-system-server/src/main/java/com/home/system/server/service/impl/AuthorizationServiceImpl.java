package com.home.system.server.service.impl;

import com.home.common.core.constant.HomeConstant;
import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.system.SystemExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import com.home.system.common.vo.ItemVo;
import com.home.system.server.domain.Authorization;
import com.home.system.server.domain.RoleAuthorization;
import com.home.system.server.repository.AuthorizationRepository;
import com.home.system.server.service.AuthorizationService;
import com.home.system.server.service.RoleAuthorizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.home.common.core.constant.HomeConstant.AUTHORIZATION_CHILD_TYPE;

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
    @Autowired
    private RoleAuthorizationService roleAuthorizationService;

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


    @Override
    public ResultVo<List<ItemVo>> findAuthorizationByAccount(String account) {
        // 获取第一级权限
        List<Authorization> parent = authorizationRepository.findByAccountAndParentId(account, 0L);
        List<ItemVo> itemVoList = this.transformItemVo(parent);

        findAuthorizationByAccountAndParentId(itemVoList, account);
        return ResultVo.ok(itemVoList);
    }

    /**
     * 通过递归补全子节点数据
     *
     * @param parent  父节点数据
     * @param account 账号
     */
    public void findAuthorizationByAccountAndParentId(List<ItemVo> parent, String account) {
        for (ItemVo itemVo : parent) {
            List<Authorization> child = authorizationRepository.findByAccountAndParentId(account, itemVo.getId());
            if (!CollectionUtils.isEmpty(child)) {
                List<ItemVo> subs = this.transformItemVo(child);
                itemVo.setSubs(subs);
                findAuthorizationByAccountAndParentId(subs, account);
            }
        }
    }

    @Override
    public ResultVo<AuthorizationVo> findAuthorizationByPrimaryKey(Long primaryKey) {
        Optional<Authorization> authorizationOptional = authorizationRepository.findById(primaryKey);
        if (authorizationOptional.isPresent()) {
            Authorization authorization = authorizationOptional.get();
            AuthorizationVo authorizationVo = new AuthorizationVo();
            BeanUtils.copyProperties(authorization, authorizationVo);
            return ResultVo.ok(authorizationVo);
        }
        return ResultVo.dataEmpty();
    }

    @Override
    public ResultVo<List<AuthorizationVo>> findAuthorizationByParentIdAndTerminalType(Long parentId, int terminalType, int childType) {
        List<Authorization> child = authorizationRepository.findByParentIdAndTerminalTypeAndDeleteFlag(parentId, terminalType);
        List<AuthorizationVo> authorizationVos = this.transformAuthorizationVo(child);
        if (AUTHORIZATION_CHILD_TYPE != childType) {
            return ResultVo.ok(authorizationVos);
        }
        findAuthorizationByParentIdAndTerminalType(authorizationVos, terminalType);
        return ResultVo.ok(authorizationVos);
    }

    /**
     * 通过递归补全子节点数据
     *
     * @param parent       父节点数据
     * @param terminalType 终端类型(0-PC端,1-Mobile端)
     */
    public void findAuthorizationByParentIdAndTerminalType(List<AuthorizationVo> parent, int terminalType) {
        for (AuthorizationVo authorizationVo : parent) {
            List<Authorization> child = authorizationRepository.findByParentIdAndTerminalTypeAndDeleteFlag(authorizationVo.getId(), terminalType);
            if (!CollectionUtils.isEmpty(child)) {
                List<AuthorizationVo> children = this.transformAuthorizationVo(child);
                authorizationVo.setChildren(children);
                findAuthorizationByParentIdAndTerminalType(children, terminalType);
            }
        }
    }



    @Override
    public void authorization(AuthorizationVo param) {
        if (null == param.getId()) {
            // 添加
            Authorization authorization = new Authorization();
            BeanUtils.copyProperties(param, authorization);
            authorization.setCreateTime(new Date());
            authorization.setUpdateTime(authorization.getCreateTime());
            authorization.setDeleteFlag(Boolean.FALSE);

            authorizationRepository.save(authorization);
        } else {
            // 修改
            Authorization authorization = this.findById(param.getId());

            BeanUtils.copyProperties(param, authorization);
            authorization.setUpdateTime(new Date());
            authorization.setDeleteFlag(Boolean.FALSE);
            authorizationRepository.save(authorization);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long... primaryKeys) {
        List<Authorization> authorizations = new ArrayList<>();
        Authorization authorization = null;
        for (Long primaryKey : primaryKeys) {
            authorization = this.findById(primaryKey);
            authorization.setUpdateTime(new Date());
            authorization.setDeleteFlag(Boolean.TRUE);
            authorizations.add(authorization);
        }
        authorizationRepository.saveAll(authorizations);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void roleAssignAuthorization(Long roleId, Long... authorizationIds) {
        // 获取旧的权限集合
        List<RoleAuthorization> roleAuthorizations = roleAuthorizationService.findRoleAuthorizationByRoleId(roleId);
        if (!CollectionUtils.isEmpty(roleAuthorizations)) {
            // 删除旧的权限集合
            roleAuthorizationService.deleteRoleAuthorization(roleAuthorizations);
        }
        // 拼装新的权限集合数据
        List<RoleAuthorization> saves = new ArrayList<>();
        RoleAuthorization save = null;
        for (Long authorizationId : authorizationIds) {
            if (HomeConstant.AUTHORIZATION_ROOT_ID == authorizationId.longValue()) {
                continue;
            }
            save = new RoleAuthorization();
            save.setRoleId(roleId);
            save.setAuthorizationId(authorizationId);
            saves.add(save);
        }
        if (!CollectionUtils.isEmpty(saves)) {
            // 添加新的权限集合
            roleAuthorizationService.saveRoleAuthorization(saves);
        }
    }

    @Override
    public Authorization findById(Long primaryKey) {
        Optional<Authorization> authorizationOptional = authorizationRepository.findById(primaryKey);
        if (authorizationOptional.isPresent()) {
            return authorizationOptional.get();
        } else {
            throw new HomeCustomException(SystemExceptionCode.AUTHORIZATION_NON_EXISTENT.getCode(), SystemExceptionCode.AUTHORIZATION_NON_EXISTENT.getMessage());
        }
    }


    private List<AuthorizationVo> transformAuthorizationVo(List<Authorization> authorizations) {
        if (CollectionUtils.isEmpty(authorizations)) {
            return new ArrayList<>();
        } else {
            return authorizations.stream().map(authorization -> {
                AuthorizationVo authorizationVo = new AuthorizationVo();
                BeanUtils.copyProperties(authorization, authorizationVo);
                return authorizationVo;
            }).collect(Collectors.toList());
        }
    }

    private List<ItemVo> transformItemVo(List<Authorization> authorizations) {
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