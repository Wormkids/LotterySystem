package com.xzj.lotterysystem;

import com.xzj.lotterysystem.common.pojo.CommonResult;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JacksonTest {
    public static void main(String[] args)
    {
        JsonMapper jsonMapper = JsonMapper.builder().build();

        CommonResult<String> commonResult = CommonResult.error(500, "系统错误");
        CommonResult<String> commonResult1;
        String str;
        str = jsonMapper.writeValueAsString(commonResult);
        System.out.println(str);
        commonResult1 = jsonMapper.readValue(str,commonResult.getClass());
        System.out.println(commonResult1);
        List<CommonResult<String>> commonResults = Arrays.asList(CommonResult.success("success1"),
                CommonResult.success("success2"));
        List<CommonResult<String>> commonResults1;
        str = jsonMapper.writeValueAsString(commonResults);
        System.out.println(str);
        commonResults1 = jsonMapper.readValue(str,commonResults.getClass());
        System.out.println(commonResults1);
    }


}
