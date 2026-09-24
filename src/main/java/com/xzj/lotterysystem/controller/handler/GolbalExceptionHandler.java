package com.xzj.lotterysystem.controller.handler;


import com.xzj.lotterysystem.common.errorcode.GlobalErrorcodeConstants;
import com.xzj.lotterysystem.common.exception.ControllerException;
import com.xzj.lotterysystem.common.exception.ServiceException;
import com.xzj.lotterysystem.common.pojo.CommonResult;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@Slf4j
@RestControllerAdvice
public class GolbalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public CommonResult<?> serviceException(ServiceException e)
    {
        //打错误日志
        log.error("ServiceException:",e);
        //构造错误结果
        return CommonResult.error(GlobalErrorcodeConstants.INTERNAL_SERVER_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(ControllerException.class)
    public CommonResult<?> controllerException(ControllerException e)
    {
        //打错误日志
        log.error("ControllerException:",e);
        //构造错误结果
        return CommonResult.error(GlobalErrorcodeConstants.INTERNAL_SERVER_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResult<?> exception(Exception e)
    {
        //打错误日志
        log.error("服务异常:",e);
        //构造错误结果
        return CommonResult.error(GlobalErrorcodeConstants.INTERNAL_SERVER_ERROR.getCode(),e.getMessage());
    }

}
