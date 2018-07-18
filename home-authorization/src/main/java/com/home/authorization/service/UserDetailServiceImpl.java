package com.home.authorization.service;

import com.home.common.core.constant.HomeConstant;
import com.home.common.core.vo.ResultVo;
import com.home.system.client.AdminClient;
import com.home.system.common.vo.AdminVo;
import com.home.system.common.vo.RoleVo;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取登录用户信息
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-11 10:16
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    /**
     * 账户可用状态码
     */
    private final static int NORMAL = 1;
    /**
     * 账户可用状态码
     */
    private final static int LOCKED = 2;

    @Autowired(required = false)
    private AdminClient adminClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResultVo<AdminVo> resultVo = adminClient.findAdminByAccount(username);
        AdminVo adminVo = (AdminVo) ResultVo.verifyResponse(resultVo);
        if (null == adminVo){
            return null;
        }

        // 账户是否可用
        boolean enabled = true;
        if (NORMAL != adminVo.getState().intValue()){
            enabled = false;
        }
        // 账户是否过期
        boolean accountNonExpired = true;
        // 密码是否过期
        boolean credentialsNonExpired = true;
        // 账户是否锁定
        boolean accountNonLocked = true;
        if (LOCKED == adminVo.getState().intValue()){
            accountNonLocked = false;
        }


        // 授权
//        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");

        List<RoleVo> roleVoList = adminVo.getRoleVoList();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleVo role : roleVoList) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        authorities.add(new SimpleGrantedAuthority(HomeConstant.BASIC_ROLE_NAEM));
        return new User(adminVo.getAccount(),adminVo.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
    }
}
