package com.home.system.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.common.web.validate.code.ValidateCodeProcessorHolder;
import com.home.common.web.validate.code.ValidateCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:53
 **/
@RestController
public class ValidateCodeRest {

    @Autowired(required = false)
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 获取验证码
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param type 验证码类型
     * @throws Exception
     */
    @RequestMapping(value = "/code/{type}", method = RequestMethod.GET)
    public ResultVo<ValidateCodeVo> createCodeImage(HttpServletRequest request, HttpServletResponse response,
                                    @PathVariable String type) throws Exception {
        ValidateCodeVo validateCodeVo = validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request,response));
        return ResultVo.ok(validateCodeVo);
    }
}
