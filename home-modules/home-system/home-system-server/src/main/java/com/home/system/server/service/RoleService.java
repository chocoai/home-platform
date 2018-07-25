package com.home.system.server.service;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.RoleVo;
import com.home.system.server.domain.Role;

import java.util.List;

/**
 * 角色 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface RoleService {

    /**
     * 根据管理员Id查询角色
     *
     * @param adminId 管理Id
     * @return List<RoleVo>
     */
    List<RoleVo> findRoleByAdminId(Long adminId);

    /**
     * 查询所有角色
     *
     * @return ResultVo<List<RoleVo>>
     */
    ResultVo<List<RoleVo>> findAll();

    /**
     * 根据账户 查询已有的角色
     *
     * @param account 账号
     * @return ResultVo<List<Long>>
     */
    ResultVo<List<Long>> findHasRoleByAccount(String account);

    /**
     * 角色修改、添加
     *
     * @param param RoleVo
     */
    void role(RoleVo param);

    /**
     * 删除角色
     *
     * @param primaryKeys 角色Id集合
     */
    void deleteRole(Long... primaryKeys);

    /**
     * 根据主键获取角色Id
     *
     * @param primaryKey 主键Id
     * @return RoleVo
     */
    RoleVo findRoleById(Long primaryKey);
}