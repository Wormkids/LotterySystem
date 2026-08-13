package com.xzj.lotterysystem.common.utils;

import tools.jackson.databind.json.JsonMapper;

import java.util.List;

public class JacksonUtil {
    JacksonUtil(){

    }
    private final static JsonMapper jsonMapper;
    static {
        jsonMapper = JsonMapper.builder().build();
    }

    private static JsonMapper getJsonMapper(){
        return jsonMapper;
    }

    /**
     * 序列化方法
     */
    public static String writeValueAsString(Object object){
        return jsonMapper.writeValueAsString(object);
    }
    /**
     * 反序列化
     */
    public static <T> T readValue(String content,Class<T> valueType){
        return jsonMapper.readValue(content,valueType);
    }

    public static <T> List<T> readListValue(String content ,Class<T> valueType){
        return readListValue(content,valueType);
    }
}
