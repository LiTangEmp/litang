package com.hyx.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Encrypt {

    /**
     * 使用BCrypt对明文密码进行加密。
     *
     * @param plainTextPassword 明文密码
     * @return 加密后的密码
     */
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    /**
     * 验证明文密码是否与加密后的密码匹配。
     *
     * @param plainTextPassword 明文密码
     * @param hashedPassword    加密后的密码
     * @return 是否匹配
     */
    // 验证密码用这个方法
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}

