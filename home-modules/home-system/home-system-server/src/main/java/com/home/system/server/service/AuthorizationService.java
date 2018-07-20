package com.home.system.server.service;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import com.home.system.common.vo.ItemVo;

import java.util.List;
import java.util.Set;

/**
 * 权限 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface AuthorizationService{

    /**
     * 根据角色查询权限
     * @param roleName 角色名
     * @return ResultVo<Set<AuthorizationVo>>
     */
    ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(String roleName);

    /**
     * 根据账号获取权限
     * @param account 账号
     * @return  ResultVo<List<ItemVo>>
     */
    ResultVo<List<ItemVo>> findAuthorizationByAccount(String account);
}