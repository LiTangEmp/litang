package com.hyx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer userId; // 用户ID
    private String username; // 用户名
    private String nickname; // 用户昵称
    private String password; // 密码
    private String userPic; // 用户头像URL
    private Integer vipId; // 会员等级ID，对应外键
    private String userPhone; // 用户手机
    private String userEmail; // 用户邮箱
    private String authority; // 用户权限级别
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间


}

