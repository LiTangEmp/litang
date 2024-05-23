package com.hyx.mapper;

import com.hyx.pojo.Resident;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ResidentMapper {
    @Select("select * from litangresident where id = #{id}")
    Resident getResidentById(Integer id);
}
