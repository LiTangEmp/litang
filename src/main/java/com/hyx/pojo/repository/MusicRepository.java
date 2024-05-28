package com.hyx.pojo.repository;

import com.hyx.pojo.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * 简单Jpa接口
 * 并没有具体逻辑实现
 * 只代表会用Jpa
 **/

public interface MusicRepository extends JpaRepository<Music, Long> {
    //扩展JPA功能

    Optional<Music> findByMusicId(Integer musicId);
    //JPA自动在Impl层中进行数据库操作
}
