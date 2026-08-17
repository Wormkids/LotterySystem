package com.xzj.lotterysystem.controller.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterParam {
    /**
     * 姓名
     */
    @NotBlank(message = "用户名不能为空！")
    private String name;


    @NotBlank(message = "邮箱不能为空！")
    private String mail;


    @NotBlank(message = "密码不能为空！")
    private String password;


    @NotBlank(message = "手机号不能为空！")
    private String phoneNumber;


    @NotBlank(message = "身份不能为空！")
    private String identity;
}
