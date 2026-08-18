package com.xzj.lotterysystem.service.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.xzj.lotterysystem.common.errorcode.ServiceErrorcodeConstants;
import com.xzj.lotterysystem.common.exception.ServiceException;
import com.xzj.lotterysystem.common.utils.RegexUtil;
import com.xzj.lotterysystem.controller.param.UserRegisterParam;
import com.xzj.lotterysystem.dao.dataobject.Encryppt;
import com.xzj.lotterysystem.dao.dataobject.UserDO;
import com.xzj.lotterysystem.dao.mapper.UserMapper;
import com.xzj.lotterysystem.service.UserService;
import com.xzj.lotterysystem.service.dto.UserRegisterDTO;
import com.xzj.lotterysystem.service.enums.UserIdentityEnum;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserRegisterDTO register(UserRegisterParam param) {
        //校验注册信息
        checkRegisterInfo(param);
        //加密私密数据
        UserDO userDO = new UserDO();
        userDO.setUserName(param.getName());
        userDO.setIdentity(param.getIdentity());
        userDO.setEmail(param.getMail());
        userDO.setPhoneNumber(new Encryppt(param.getPhoneNumber()));
        //普通用户密码可能为空
        if (StringUtils.hasText(param.getPassword())){
            userDO.setPassword(DigestUtil.sha256Hex(param.getPassword()));
        }
        //保存数据
        userMapper.insert(userDO);
        //构造返回
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setUserId(userDO.getId());
        return userRegisterDTO;

    }

    private void checkRegisterInfo(UserRegisterParam param) {
        if(param == null)
        {
            throw new ServiceException(ServiceErrorcodeConstants.REGISTER_INFO_EMPTY);
        }
        if (!RegexUtil.checkMail(param.getMail())){
            throw new ServiceException(ServiceErrorcodeConstants.MAIL_EMPTY);
        }
        if(!RegexUtil.checkMobile(param.getPhoneNumber())){
            throw new ServiceException(ServiceErrorcodeConstants.PHONE_NUMBER_IS_EMPTY);
        }
        if(UserIdentityEnum.forName(param.getIdentity()) == null) {
            throw new ServiceException(ServiceErrorcodeConstants.IDENTITY_ERROR);
        }
        if(param.getIdentity().equalsIgnoreCase(UserIdentityEnum.ADMIN.name())
                && !StringUtils.hasText(param.getPassword()))
        {
            throw new ServiceException(ServiceErrorcodeConstants.PASSWORD_IS_EMPTY);
        }
        if (StringUtils.hasText(param.getPassword())
                && !RegexUtil.checkPassword(param.getPassword())) {
            throw new ServiceException(ServiceErrorcodeConstants.PASSWORD_ERROR);
        }
        if(checkMailUsed(param.getMail())){
            throw new ServiceException(ServiceErrorcodeConstants.MAIL_USED);
        }
        if(checkPhoneNumberUsed(param.getPhoneNumber()))
        {
            throw new ServiceException(ServiceErrorcodeConstants.PHONE_NUMBER_USED);
        }
    }

    private boolean checkPhoneNumberUsed(@NotBlank(message = "手机号不能为空！") String phoneNumber) {
        int count = userMapper.countByPhoneNumber(new Encryppt(phoneNumber));
        return count > 0;
    }

    private boolean checkMailUsed(String mail) {
        int count = userMapper.countByMail(mail);
        return count > 0;
    }
}
