package com.hyx.pojo;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Music {
    private Integer musicId;//音乐ID
    private String title;//音乐标题
    private String genre;//音乐类型
    private String releaseDate;//音乐发行日期
    private String filePath;//音乐文件路径
    private Timestamp createTime;//音乐创建时间
    private Timestamp updateTime;//音乐更新时间
}
