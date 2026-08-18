package com.xzj.lotterysystem;


import com.xzj.lotterysystem.common.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void Redistest()
    {
//        stringRedisTemplate.opsForValue().set("key1","value1");
//        String key1 = stringRedisTemplate.opsForValue().get("key1");
//        System.out.println(key1);
//        boolean set = redisUtil.set("key2", "value2", 10L);
//        System.out.println(set);
//        String get = redisUtil.get("key2");
//        System.out.println(get);
//        boolean del = redisUtil.del("key1", "key2");
//        System.out.println(del);
//        boolean key1 = redisUtil.haskey("key1");
//        System.out.println(key1);

    }
}
