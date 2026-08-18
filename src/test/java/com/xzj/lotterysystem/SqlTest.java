package com.xzj.lotterysystem;

import com.xzj.lotterysystem.dao.dataobject.Encryppt;
import com.xzj.lotterysystem.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SqlTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void PhoneNumberTest(){
        int count  = userMapper.countByMail("1513138130@qq.com");
        System.out.println(count);
    }

    @Test
    void MailTest(){
        int count = userMapper.countByPhoneNumber(new Encryppt("13592267849"));
        System.out.println("PhoneNumber Used count = "+ count);
    }
}
