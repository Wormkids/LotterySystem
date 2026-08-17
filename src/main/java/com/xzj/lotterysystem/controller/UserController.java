package com.xzj.lotterysystem.controller;


import com.xzj.lotterysystem.common.errorcode.ControllerErrorcodeConstants;
import com.xzj.lotterysystem.common.exception.ControllerException;
import com.xzj.lotterysystem.common.pojo.CommonResult;
import com.xzj.lotterysystem.common.utils.JacksonUtil;
import com.xzj.lotterysystem.controller.param.UserRegisterParam;
import com.xzj.lotterysystem.controller.result.UserRegisterResult;
import com.xzj.lotterysystem.service.UserService;
import com.xzj.lotterysystem.service.dto.UserRegisterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public CommonResult<UserRegisterResult> userRegister(
            @Validated @RequestBody UserRegisterParam param)
    {
        logger.info("userRegister UserRegisterParam :{}", JacksonUtil.writeValueAsString( param));
        UserRegisterDTO userRegisterDTO = userService.register(param);
        return CommonResult.success(convertToUserRegisterResult(userRegisterDTO));
    }

    private UserRegisterResult convertToUserRegisterResult(UserRegisterDTO userRegisterDTO) {
        UserRegisterResult result = new UserRegisterResult();;
        if (userRegisterDTO == null)
        {
            throw new ControllerException(ControllerErrorcodeConstants.REGISTER_ERROR);
        }
        result.setUserId(userRegisterDTO.getUserId());
        return result;
    }
}
