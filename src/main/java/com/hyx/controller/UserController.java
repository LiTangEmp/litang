package com.hyx.controller;

import com.hyx.pojo.Result;
import com.hyx.pojo.User;
import com.hyx.service.UserService;
import com.hyx.utils.Encrypt;
import com.hyx.utils.JwtUtil;
import com.hyx.utils.ThreadLocalUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


//此处实现注册方法
    @PostMapping("/register")
public Result<String> register(User user) {    //public Result<String> register(@RequestBody User user)这里如果添加@RequestBody，则需要前端传json格式数据
    try {
        userService.register(user.getUsername(), user.getPassword());
        return Result.success("注册成功");
    } catch (Exception e) {
        e.printStackTrace();
        return Result.fail("注册失败：" + e.getMessage());
    }
}
//此处实现登录方法
@PostMapping("/login")
public Result<String> login( User user) {
    log.info("用户登录：" + user);
    try {
        //user.setPassword(Encrypt.hashPassword(user.getPassword()));
        //这里不能把加密后的密码传给service层，因为service层需要明文密码进行对比
        Result <String> res = userService.login(user.getUsername(), user.getPassword());
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("username", user.getUsername());
//        String token = jwtUtil.generateToken(claims);
//        return Result.success(token);
        if (res.getCode() != 0){
            return Result.fail("登录失败：" + res.getMessage());
        }
        return Result.success(res.getData());
    } catch (Exception e) {
        return Result.fail("登录失败：" + e.getMessage());
    }
}

@GetMapping("/getUserInfo")
public Result<User> getUserInfo() {
    try {
        Map<String , Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    } catch (Exception e) {
        return Result.fail("获取用户信息失败：" + e.getMessage());
    }
}

@PutMapping("/updateUserInfo")
    public Result updateUserInfo(User user) {
    log.info("更新的用户信息：" + user);

        try {
            userService.updateUserInfo(user);
            return Result.success("更新用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("更新用户信息失败：" + e.getMessage());
        }
    }

@PatchMapping("/updatePassword")
    public Result updatePassword(String password , @RequestHeader("Authorization") String token) {
        log.info("更新的密码：" + password);
        try {
            userService.updatePassword(password);
            //删除原来的token
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.getOperations().delete(token);
            return Result.success("更新密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("更新密码失败：" + e.getMessage());
        }
    }

    }
