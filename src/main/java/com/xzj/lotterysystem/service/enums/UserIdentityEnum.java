package com.xzj.lotterysystem.service.enums;


import com.xzj.lotterysystem.controller.param.UserRegisterParam;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserIdentityEnum {

    ADMIN("管理员"),
    NORMAL("普通用户");

    private final String message;

    public static UserIdentityEnum forName(String identity){
        for(UserIdentityEnum userIdentityEnum : UserIdentityEnum.values())
        {
            if(!userIdentityEnum.name().equalsIgnoreCase(identity))
            {
                return userIdentityEnum;
            }
        }
        return null;
    }


}
