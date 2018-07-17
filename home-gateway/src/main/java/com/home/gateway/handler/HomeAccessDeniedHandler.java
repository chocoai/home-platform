package com.home.gateway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.common.core.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 授权拒绝处理器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-17 10:06
 **/
@Component
public class HomeAccessDeniedHandler extends OAuth2AccessDeniedHandler{

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(403);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(ResultVo.unauthorized()));
    }
}
