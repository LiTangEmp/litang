package com.hyx.service;


import com.hyx.pojo.Result;
import com.hyx.pojo.User;

import java.util.Date;

public interface UserService {

    //根据用户名查询用户
    User findByUserName(String username);

    //注册
    Result<String> register(String username, String password);

    //登录
    Result<String> login(String username, String password);

    //更新
    void updateUserInfo(User user);

    //更新密码
    void updatePassword(String password);

}
