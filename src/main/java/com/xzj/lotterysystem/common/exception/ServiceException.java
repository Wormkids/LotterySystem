package com.xzj.lotterysystem.common.exception;

import com.xzj.lotterysystem.common.errorcode.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException{
    /**
     * 错误码
     * @see com.xzj.lotterysystem.common.errorcode.ServiceErrorcodeConstants
     */
    private Integer code;
    private String message;

    public ServiceException() {

    }
    public ServiceException(Integer code, String message)
    {
        this.code = code;
        this.message = message;

    }
    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

}
