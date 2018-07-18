package com.home.gateway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.common.core.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * token 异常时返回数据
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-18 17:23
 **/
@Component
public class HomeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(200);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(ResultVo.unauthorized()));
    }
}
