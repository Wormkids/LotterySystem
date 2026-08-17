package com.xzj.lotterysystem.service.impl;

import com.xzj.lotterysystem.controller.param.UserRegisterParam;
import com.xzj.lotterysystem.service.UserService;
import com.xzj.lotterysystem.service.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserRegisterDTO register(UserRegisterParam param) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setUserId(12L);
        return userRegisterDTO;

    }
}
