package com.hyx.interceptors;

import com.hyx.utils.JwtUtil;
import com.hyx.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response , Object handler) throws Exception{
        //prehandle在controller前执行
        String token = request.getHeader("Authorization");//通过请求头传入一个Token
        log.info("token1获取为：{}",token);//打印日志记得要加占位符
        // 检查Token是否存在
        if (token == null || token.trim().isEmpty()) {
            response.setStatus(401); // Token不存在，返回401
            return false;
        }
        log.info("token2获取为：{}",token);
        try{
            //从redis中获取token存在redis中的token进行检验
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String tokenRedis = operations.get(token);
            if (tokenRedis == null){
                //token失效
                throw new RuntimeException("token失效");
            }
            Map<String , Object> claims = JwtUtil.parseToken(token);
            // 将数据业务放入ThreadLocal
            ThreadLocalUtil.set(claims);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}
