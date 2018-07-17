package com.home.common.web.handler;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.ValidateCodeException;
import com.home.common.core.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * 异常处理器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-01 17:02
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 处理自定义异常
     * Map<String, Object>
     *
     * @param ex CustomException
     * @return ResultVo
     */
    @ExceptionHandler(HomeCustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo handleCustomException(HomeCustomException ex) {
        return ResultVo.custom(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理登陆超时异常
     *
     * @param ex LoginTimeOutException
     * @return ResultVo
     */
    @ExceptionHandler(ValidateCodeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo handleLoginTimeOutException(ValidateCodeException ex) {
        return ResultVo.custom(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理 HttpMediaTypeNotSupportedException
     *
     * @param ex HttpMediaTypeNotSupportedException
     */
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public void handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        System.out.println(ex.getMessage());
    }

    /**
     * 处理 HttpMessageNotReadableException
     *
     * @param ex HttpMessageNotReadableException
     * @return 错误信息
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVo handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResultVo.badRequest();
    }

    /**
     * 处理 MethodArgumentNotValidException
     *
     * @param ex MethodArgumentNotValidException
     * @return 错误信息
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultVo handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult errors = ex.getBindingResult();
        List<ObjectError> objectErrors = errors.getAllErrors();
        if (null != objectErrors && objectErrors.size() > 0) {
            for (ObjectError error : objectErrors) {
                FieldError fieldError = (FieldError) error;
                StringBuffer message = new StringBuffer();
                message.append("[");
                message.append(fieldError.getField());
                message.append("]");
                message.append(error.getDefaultMessage());
                return ResultVo.custom(HttpStatus.BAD_REQUEST.value(), message.toString());
            }
            return ResultVo.badRequest();
        } else {
            return ResultVo.badRequest();
        }
    }

    /**
     * 处理默认Exception
     *
     * @param ex Exception
     * @return ResultVo
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo handleException(Exception ex) {
        LOG.error(ex.getMessage(), ex);
        return ResultVo.serverError();
    }

}
