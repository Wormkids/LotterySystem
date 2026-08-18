package com.xzj.lotterysystem.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;


@Configuration
@Slf4j
public class RedisUtil {

    /**
     * RedisTemplate :  先将被存储的数据转换成 字节数组（不可读），再存储到redis中，读取的时候按照字节数组读取
     * StringRedisTemplate ： 直接存放的就是 string (可读)
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,String value){
        try {
            stringRedisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            log.error("RedisUtil error in set({},{})",key,value,e);
            return false;
        }
    }

    /**
     *
     * @param key
     * @param value
     * @param time  单位 秒
     * @return
     */
    public boolean set(String key,String value,Long time){
        try {
            stringRedisTemplate.opsForValue().set(key,value, Duration.ofSeconds(time));
            return true;
        } catch (Exception e) {
            log.error("RedisUtil error in set({},{},{})",key,value,time,e);
            return false;
        }
    }
    /**
     * 取值
     * @param key
     * @return
     */
    public String get(String key){
        try {
            return StringUtils.hasText(key)
                    ? stringRedisTemplate.opsForValue().get(key)
                    : null;
        } catch (Exception e) {
            log.error("RedisUtil error in get({})",key,e);
            return null;
        }
    }

    /**
     * 删除值
     * @param keys
     * @return
     */
    public boolean del(String... keys){
        try {
            if(keys != null && keys.length >0){
                if(keys.length == 1){
                    stringRedisTemplate.delete(keys[0]);
                }
                else{
                    stringRedisTemplate.delete(
                            Arrays.asList(keys)
                    );
                }

            }
            return true;
        } catch (Exception e) {
            log.error("RedisUtil error in del({})",Arrays.asList(keys),e);
            return false;
        }
    }

    /**
     * 判断键是否存在
     * @param key
     * @return
     */
    public boolean haskey(String key){
        try {
            return StringUtils.hasText(key)
                    ? stringRedisTemplate.hasKey(key)
                    : false;
        } catch (Exception e) {
            log.error("RedisUtil error in haskey({})",key,e);
            return false;
        }
    }
}
