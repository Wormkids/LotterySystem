package com.xzj.lotterysystem.dao.dataobject;

import com.xzj.lotterysystem.controller.param.UserRegisterParam;
import com.xzj.lotterysystem.service.dto.UserRegisterDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseDO{
    private String email;
    private String password;
    private String identity;
    private String userName;
    private Encryppt phoneNumber;
}
