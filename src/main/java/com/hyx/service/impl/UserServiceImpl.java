package com.hyx.service.impl;

import com.hyx.mapper.UserMapper;
import com.hyx.pojo.Result;
import com.hyx.pojo.User;
import com.hyx.service.UserService;
import com.hyx.utils.Encrypt;
import com.hyx.utils.JwtUtil;
import com.hyx.utils.ThreadLocalUtil;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 根据用户名查询用户具体实现
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    // 注册具体实现
    @Override
    public Result<String> register(String username, String password) {
        User existingUser = findByUserName(username);
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
            //return Result.fail("用户名已存在");
            //返回Result会导致用户名已存在的情况下依然注册成功
        } else {
            // 实现注册逻辑，保存用户信息到数据库
            String encryptedPassword = Encrypt.hashPassword(password);
            log.info("username" +username,"encryptedPassword" +encryptedPassword);
            //saveuser在这调用，用于往数据库里插一条数据
            userMapper.saveUser(username, encryptedPassword);
            return Result.success("注册成功");
        }
    }

    // 登录具体实现
    @Override
    public Result<String> login(String username, String password) {
        // 查询用户
        User user = userMapper.findByUserName(username);
        log.info("user: " + user);

        // 用户不存在
        if (user == null) {
            //throw new RuntimeException("用户名不存在");
            return Result.fail("用户名不存在");
            //返回Result会在名字错误的情况下报密码错误
        }

        // 使用Encrypt工具类校验密码
        if (Encrypt.verifyPassword(password, user.getPassword())) {
            Map<String , Object> claims = new HashMap<>();
            claims.put("userId", user.getUserId());
            claims.put("username", user.getUsername());
            log.info("claims: " + claims);
            String token = jwtUtil.generateToken(claims);
            //把token存在redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 3600);
            return Result.success(token);
        }else {
            // 密码错误
            return Result.fail("密码错误");
        }

    }

    //更新用户信息具体实现
    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public void updatePassword(String password) {
        Map<String , Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("userId");
        String encryptedPassword = Encrypt.hashPassword(password);
        userMapper.updatePassword(encryptedPassword , userId);
    }






    }



