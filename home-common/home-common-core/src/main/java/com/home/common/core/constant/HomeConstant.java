package com.home.common.core.constant;

/**
 * home-platform 常量
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:53
 **/
public interface HomeConstant {
    /**
     * 验证码缓存Key 前缀
     */
    String VALIDATE_CODE_PREFIX = "home_validate_code_";
    /**
     * 基础角色名
     */
    String BASIC_ROLE_NAME = "BASIC_ROLE";
    /**
     * 不修改管理员密码的标志
     */
    String NO_MODIFY_PASSWORD = "NO";
    /**
     * 获取所有子节点
     */
    int AUTHORIZATION_CHILD_TYPE = 0;
    /**
     * 权限根节点ID
     */
    long AUTHORIZATION_ROOT_ID = 0;
}
