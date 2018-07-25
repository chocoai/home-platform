package com.home.gateway.service;

import com.home.common.core.constant.HomeConstant;
import com.home.common.core.vo.ResultVo;
import com.home.system.client.AuthorizationClient;
import com.home.system.common.vo.AuthorizationVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-18 13:30
 **/
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private AuthorizationClient authorizationClient;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (null != principal) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) {
                return hasPermission;
            }

            Set<AuthorizationVo> urls = new HashSet<>();
            for (SimpleGrantedAuthority authority : grantedAuthorityList) {
                String roleName = authority.getAuthority();
                if (StringUtils.equals(HomeConstant.BASIC_ROLE_NAME, roleName)) {
                    continue;
                }
                ResultVo<Set<AuthorizationVo>> resultVo = authorizationClient.findAuthorizationByRole(roleName);
                Set<AuthorizationVo> authorizationVos = (Set<AuthorizationVo>) ResultVo.verifyResponse(resultVo);
                if (!CollectionUtils.isEmpty(authorizationVos)) {
                    urls.addAll(authorizationVos);
                }

            }

            for (AuthorizationVo menu : urls) {
                if (StringUtils.isNotEmpty(menu.getUrl()) && antPathMatcher.match(menu.getUrl(), request.getRequestURI())) {
                    hasPermission = true;
                }
            }
        }

        logger.debug("鉴权 -- url : {} --  是否有权限: {} ", request.getRequestURI(), hasPermission);

        return hasPermission;
    }
}
