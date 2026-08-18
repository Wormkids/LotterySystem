package com.xzj.lotterysystem.dao.mapper;


import com.xzj.lotterysystem.dao.dataobject.Encryppt;
import com.xzj.lotterysystem.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    /**
     * 检查邮箱是否被使用过，返回邮箱在数据库中存在的次数
     * @param email
     * @return
     */
    @Select("select count(*) from user where email = #{email}")
    int countByMail(@Param("email")String email);

    /**
     * 检查手机号是否使用过，返回在数据库中存在的次数
     * @param phone_number
     * @return
     */
    @Select("select count(*) from user where phone_number = #{phone_number}")
    int countByPhoneNumber(@Param("phone_number") Encryppt phone_number);

    @Insert("insert into user (email,phone_number,password,identity,user_name)  "+
                "values (#{email},#{phoneNumber},#{password},#{identity},#{userName})")
    @Options(useGeneratedKeys = true ,keyProperty = "id",keyColumn = "id")
    void insert(UserDO userDO);
}
