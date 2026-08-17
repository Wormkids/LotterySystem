package com.xzj.lotterysystem.service;


import com.xzj.lotterysystem.controller.param.UserRegisterParam;
import com.xzj.lotterysystem.service.dto.UserRegisterDTO;


public interface UserService {
    /**
     * 注册
     */
    UserRegisterDTO register(UserRegisterParam param);

}
