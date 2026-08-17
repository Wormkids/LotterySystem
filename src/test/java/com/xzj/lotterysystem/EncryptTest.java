package com.xzj.lotterysystem;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
public class EncryptTest {

    @Test
    void SHA256Test()
    {
        String password = "123456789";
        String Encrypt= DigestUtil.sha256Hex(password);
        System.out.println(Encrypt);

    }

    @Test
    void ASETest()
    {
        String password = "123456789";
        //密钥 16，24，32 字节
        byte[] key = "1234567890123456".getBytes(StandardCharsets.UTF_8);

        AES aes = SecureUtil.aes(key);
        String Encrypt =  aes.encryptHex(password);
        System.out.println(Encrypt);

        System.out.println(aes.decryptStr(Encrypt));
    }
}
