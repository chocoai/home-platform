package com.home.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断权限
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-18 13:30
 **/
public interface PermissionService {

    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
