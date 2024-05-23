package com.hyx.controller;


import com.hyx.pojo.Music;
import com.hyx.pojo.Result;
import com.hyx.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/add")
    public Result addMusic(Music music) {
        log.info("添加音乐信息：", music);
        try{
            musicService.addMusic(music);
            return Result.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("添加失败" + e.getMessage());
        }
    }
}
