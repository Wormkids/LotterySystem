package com.xzj.lotterysystem.common.pojo;

import com.xzj.lotterysystem.common.errorcode.ErrorCode;
import com.xzj.lotterysystem.common.errorcode.GlobalErrorcodeConstants;
import org.springframework.util.Assert;

public class CommonResult<T> {
    /**
     * 返回的错误码
     */
    private Integer code;
    /**
     * 错误码描述
     */
    private String msg;
    /**
     * 无错误产生正常返回的数据,出错为null
     */
    private T data;

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorcodeConstants.SUCCESS.getCode();
        result.data = data;
        result.msg = GlobalErrorcodeConstants.SUCCESS.getMsg();
        return result;
    }

    public static <T> CommonResult<T> error(Integer code, String msg) {
        Assert.isTrue(!GlobalErrorcodeConstants.SUCCESS.getCode().equals(code), "code不是错误异常");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static <T>  CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(),errorCode.getMsg());
    }


}
