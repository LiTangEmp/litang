package com.hyx.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *hello测试类，没用
 */
@RestController

public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello123";
    }
}
