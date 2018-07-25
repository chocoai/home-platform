package com.home.system.server.service;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import com.home.system.common.vo.ItemVo;
import com.home.system.server.domain.Authorization;

import java.util.List;
import java.util.Set;

/**
 * 权限 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface AuthorizationService {

    /**
     * 根据角色查询权限
     *
     * @param roleName 角色名
     * @return ResultVo<Set<AuthorizationVo>>
     */
    ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(String roleName);

    /**
     * 根据账号获取权限
     *
     * @param account 账号
     * @return ResultVo<List<ItemVo>>
     */
    ResultVo<List<ItemVo>> findAuthorizationByAccount(String account);

    /**
     * 根据Id获取权限详情
     *
     * @param primaryKey 主键Id
     * @return ResultVo<AuthorizationVo>
     */
    ResultVo<AuthorizationVo> findAuthorizationByPrimaryKey(Long primaryKey);

    /**
     * 根据父节点和终端类型获取权限列表
     *
     * @param parentId     父节点Id
     * @param terminalType 终端类型(0-PC端,1-Mobile端)
     * @param childType    获取子节点类型(0-所有子节点,1-直属子节点)
     * @return ResultVo<List<AuthorizationVo>>
     */
    ResultVo<List<AuthorizationVo>> findAuthorizationByParentIdAndTerminalType(Long parentId, int terminalType, int childType);



    /**
     * 根据Id获取权限详情
     *
     * @param primaryKey 主键Id
     * @return Authorization
     * @throws HomeCustomException 不存在抛不存在异常
     */
    Authorization findById(Long primaryKey) throws HomeCustomException;

    /**
     * 权限修改、添加
     *
     * @param param AuthorizationVo
     */
    void authorization(AuthorizationVo param);

    /**
     * 删除
     *
     * @param primaryKeys 主键Id集合
     */
    void delete(Long... primaryKeys);

    /**
     * 角色分配权限
     *
     * @param roleId           角色Id
     * @param authorizationIds 分配的权限Id集合
     */
    void roleAssignAuthorization(Long roleId, Long... authorizationIds);
}