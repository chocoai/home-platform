package com.home.common.core.vo;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.vo.status.HomeHttpStatus;
import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 14:49
 **/
@Data
public class ResultVo<T> {

    private ResultVo() {
    }

    private Integer code;
    private String message;
    private T data;

    /**
     * 请求成功
     *
     * @return ResultVo
     */
    public static ResultVo ok() {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.OK.getCode());
        result.setMessage(HomeHttpStatus.OK.getMessage());
        return result;
    }

    /**
     * 请求成功
     *
     * @param data Object
     * @return ResultVo
     */
    public static ResultVo ok(Object data) {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.OK.getCode());
        result.setMessage(HomeHttpStatus.OK.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 请求成功,查询无数据
     *
     * @return ResultVo
     */
    public static ResultVo dataEmpty() {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.DataEmpty.getCode());
        result.setMessage(HomeHttpStatus.DataEmpty.getMessage());
        return result;
    }

    /**
     * 参数错误
     *
     * @return ResultVo
     */
    public static ResultVo badRequest() {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.BadRequest.getCode());
        result.setMessage(HomeHttpStatus.BadRequest.getMessage());
        return result;
    }

    /**
     * 访问被拒绝
     *
     * @return ResultVo
     */
    public static ResultVo unauthorized() {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.Unauthorized.getCode());
        result.setMessage(HomeHttpStatus.Unauthorized.getMessage());
        return result;
    }

    /**
     * 服务器繁忙
     *
     * @return ResultVo
     */
    public static ResultVo serverError() {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.ServerError.getCode());
        result.setMessage(HomeHttpStatus.ServerError.getMessage());
        return result;
    }

    /**
     * 服务断路
     * @return ResultVo
     */
    public static ResultVo hystrix(){
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.Hystrix.getCode());
        result.setMessage(HomeHttpStatus.Hystrix.getMessage());
        return result;
    }

    /**
     * 自定义响应数据
     *
     * @param code    响应码
     * @param message 响应提示信息
     * @return ResultVo
     */
    public static ResultVo custom(Integer code, String message) {
        ResultVo result = new ResultVo();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


    /**
     * 自定义响应数据
     *
     * @param message 响应提示信息
     * @return ResultVo
     */
    public static ResultVo custom(String message) {
        ResultVo result = new ResultVo();
        result.setCode(HomeHttpStatus.ServerError.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 自定义响应数据
     *
     * @param code    响应码
     * @param message 响应提示信息
     * @param data    响应数据
     * @return ResultVo
     */
    public static ResultVo custom(Integer code, String message, Object data) {
        ResultVo result = new ResultVo();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 验证响应数据<有响应数据>是否合法
     *
     * @param resultVo ResultVo<?>
     * @param <T>      ?
     * @return T
     */
    public static <T> Object verifyResponse(ResultVo<?> resultVo) {
        Integer code = resultVo.getCode();
        if (code.intValue() == HomeHttpStatus.OK.getCode().intValue()) {
            return resultVo.getData();
        } else if (code.intValue() == HomeHttpStatus.DataEmpty.getCode().intValue()) {
            return null;
        } else {
            throw new HomeCustomException(resultVo.getCode(), resultVo.getMessage());
        }
    }

    /**
     * 验证响应数据<无响应数据>是否合法
     *
     * @param resultVo ResultVo<?>
     */
    public static void verifyVoid(ResultVo resultVo) {
        Integer code = resultVo.getCode();
        if (code.intValue() != HomeHttpStatus.OK.getCode().intValue()) {
            throw new HomeCustomException(resultVo.getCode(), resultVo.getMessage());
        }
    }
}
