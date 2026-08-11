package com.xzj.lotterysystem.common.exception;

import com.xzj.lotterysystem.common.errorcode.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ControllerException extends RuntimeException{
    /**
     * 错误码
     *@see com.xzj.lotterysystem.common.errorcode.ControllerErrorcodeConstants
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;

    /**
     * 空构造是为了序列化
     */
    public ControllerException() {

    }
    public ControllerException(Integer code, String message)
    {
        this.code = code;
        this.message = message;

    }
    public ControllerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }




}
