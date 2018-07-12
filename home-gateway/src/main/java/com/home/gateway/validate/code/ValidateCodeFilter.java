package com.home.gateway.validate.code;

import com.home.common.web.validate.code.ValidateCodeProcessorHolder;
import com.home.common.web.validate.code.ValidateCodeType;
import com.home.common.web.validate.code.config.ValidateCodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 验证码过滤器逻辑
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:07
 **/
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter {

    @Autowired(required = false)
    private ValidateCodeProperties validateCodeProperties;
    @Autowired(required = false)
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 存放所有需要校验验证码的URL
     */
    private Map<String, ValidateCodeType> anonsUrl = new HashMap<>();
    /**
     * 验证请求URL与配置的URL是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        List<String> smsAnon = validateCodeProperties.getSms().getAnon();
        for (String anon : smsAnon) {
            anonsUrl.put(anon, ValidateCodeType.SMS);
        }

        List<String> imageAnon = validateCodeProperties.getSms().getAnon();
        for (String anon : imageAnon) {
            anonsUrl.put(anon, ValidateCodeType.IMAGE);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ValidateCodeType validateCodeType = null;
        Set<String> anons = anonsUrl.keySet();
        for (String anon : anons) {
            if (pathMatcher.match(anon, request.getRequestURI())) {
                validateCodeType = anonsUrl.get(anon);
            }
        }

        if (null != validateCodeType) {
            String random = request.getParameter("random");
            String code = request.getParameter("code");
            validateCodeProcessorHolder.findValidateCodeProcessor(validateCodeType).validate(random, code);
        } else {
            filterChain.doFilter(request, response);
        }
    }


}
