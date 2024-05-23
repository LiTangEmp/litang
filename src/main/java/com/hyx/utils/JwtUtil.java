package com.hyx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtUtil {

    private static final String KEY = "hyx";

    //接受业务数据，生产token并返回
    public static String generateToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256(KEY));
    }
    //接受token，验证token，返回业务数据
    public static Map<String , Object> parseToken(String token) {
        //可能在lombok依赖版本低于1.18.30时，parseToken（）无法正确的获取到token，一直是null
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
