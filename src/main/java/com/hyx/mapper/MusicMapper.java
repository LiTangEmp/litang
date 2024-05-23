package com.hyx.mapper;

import com.hyx.pojo.Music;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MusicMapper {

    @Insert("INSERT INTO music (title, genre, release_date, created_time, updated_time) " +
            "VALUES (#{title}, #{genre}, #{releaseDate}, NOW(), NOW())")
    void addMusic(Music music);
}
