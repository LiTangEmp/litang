package com.hyx.mapper;

import com.hyx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
@Mapper
public interface UserMapper {

    //根据用户名查询用户
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUserName(String username);

    // saveUser注册时向数据库中插入数据
    @Insert("INSERT INTO user (username, password, createtime, updatetime) " +
            "VALUES (#{username}, #{password}, NOW(), NOW())")
    void saveUser(String username, String password);//注意参数名要相同

    // 更新用户信息
    @Update("UPDATE user SET nickname = #{nickname}, userPhone = #{userPhone}, userEmail = #{userEmail}, updatetime = NOW() " +
            "WHERE userId = #{userId}")
    void updateUserInfo(User user);


    @Update("UPDATE user SET password = #{encryptedPassword} , updatetime = NOW()" +
            " WHERE userId = #{userId}")
    void updatePassword(String encryptedPassword , Integer userId);
}

