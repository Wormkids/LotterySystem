package com.xzj.lotterysystem.common.errorcode;

import lombok.Data;

@Data
public class ErrorCode {
    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误码对应的错误信息
     */
    private final String msg;
    public ErrorCode(Integer code,String msg)
    {
        this.code = code;
        this.msg = msg;
    }

}
