package com.xzj.lotterysystem.common.errorcode;

public interface ServiceErrorcodeConstants {
    ErrorCode REGISTER_INFO_EMPTY = new ErrorCode(100,"注册信息为空");
    ErrorCode MAIL_EMPTY = new ErrorCode(101,"邮箱格式错误");
    ErrorCode PHONE_NUMBER_IS_EMPTY = new ErrorCode(102,"手机号格式错误");
    ErrorCode IDENTITY_ERROR = new ErrorCode(103,"身份信息错误");
    ErrorCode PASSWORD_IS_EMPTY = new ErrorCode(104,"密码为空");
    ErrorCode PASSWORD_ERROR = new ErrorCode(105,"密码格式错误");
    ErrorCode MAIL_USED = new ErrorCode(106,"邮箱被使用");
    ErrorCode PHONE_NUMBER_USED = new ErrorCode(107,"手机号被使用");



}
