package com.hyx.controller;


import com.hyx.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/internal")
@RestController
public class InternalController {

    @GetMapping("/list")
    public  Result<String> list()
    {
        return Result.success("hello world");
    }
}
