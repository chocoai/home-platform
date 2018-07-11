package com.home.system.client;

import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AdminVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * system - admin 客户端
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-10 18:12
 **/
@FeignClient(
        name = "system",
        fallback = AdminClient.AdminClientFallback.class
)
public interface AdminClient {

    /**
     * system 服务访问前缀
     */
    String SYSTEM_ADMIN_SERVER_PREFIX = "/admin";

    /**
     * 查询Admin信息
     *
     * @param account 登录账号
     * @return ResultVo<AdminVo>
     */
    @RequestMapping(value = SYSTEM_ADMIN_SERVER_PREFIX + "/account", method = RequestMethod.GET)
    ResultVo<AdminVo> findAdminByAccount(@RequestParam(name = "account") String account);

    class AdminClientFallback implements AdminClient {
        @Override
        public ResultVo<AdminVo> findAdminByAccount(String account) {
            return ResultVo.hystrix();
        }
    }
}
