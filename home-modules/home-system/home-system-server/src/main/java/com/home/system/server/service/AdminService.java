package com.home.system.server.service;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AdminVo;
import com.home.system.server.domain.Admin;
import org.springframework.data.domain.Page;

/**
 * 管理员 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
public interface AdminService{

    /**
     *  根据主键查询管理员
     * @param primaryKey 主键
     * @return ResultVo<AdminVo>
     */
    ResultVo<AdminVo> findAdminByPrimaryKey(Long primaryKey);

    /**
     * 根据 管理员登录账号获取 管理员信息
     * @param account 账号
     * @return ResultVo<AdminVo>
     */
    ResultVo<AdminVo> findAdminByAccount(String account);

    ResultVo<Page<AdminVo>> page(int page, int size);
}