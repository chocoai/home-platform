package com.home.system.client;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AuthorizationVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-18 13:35
 **/
@FeignClient(
        name = "system",
        fallback = AuthorizationClient.AuthorizationClientFallback.class
)
public interface AuthorizationClient {
    /**
     * system 服务访问前缀
     */
    String SYSTEM_AUTHORIZATION_SERVER_PREFIX = "/authorization";

    /**
     * 根据角色名获取权限
     *
     * @param roleName 角色名
     * @return ResultVo<List<AuthorizationVo>>
     */
    @RequestMapping(value = SYSTEM_AUTHORIZATION_SERVER_PREFIX + "/role", method = RequestMethod.GET)
    ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(@RequestParam(name = "roleName") String roleName);

    @Component
    class AuthorizationClientFallback implements AuthorizationClient {
        @Override
        public ResultVo<Set<AuthorizationVo>> findAuthorizationByRole(String roleName) {
            return ResultVo.hystrix();
        }
    }

}
