package com.hyx.service.impl;

import com.hyx.mapper.MusicMapper;
import com.hyx.pojo.Music;
import com.hyx.service.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicServiceImpl implements MusicService {

    private static final Logger log = LoggerFactory.getLogger(MusicServiceImpl.class);
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public void addMusic(Music music)
    {
        musicMapper.addMusic(music);
    }
}
