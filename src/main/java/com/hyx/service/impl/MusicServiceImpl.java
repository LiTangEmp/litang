package com.hyx.service.impl;

import com.hyx.mapper.MusicMapper;
import com.hyx.pojo.Music;
import com.hyx.pojo.repository.MusicRepository;
import com.hyx.service.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class MusicServiceImpl implements MusicService {

    private static final Logger log = LoggerFactory.getLogger(MusicServiceImpl.class);
    @Autowired
    private MusicMapper musicMapper;

    private final MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    @Override
    public void addMusic(Music music)
    {
        musicMapper.addMusic(music);
    }
}
