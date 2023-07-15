package com.blog.mapper;

import com.blog.entity.Key;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface KeyMapper {

    @Select("select * from `key` where `canUse` = 'true'")
    List<Key> findAllKey();

    @Update("update `key` set `canUse` = 'false' where `key` = #{key}")
    int updateKey(String key);

    @Insert("insert into `key`(`key`,canUse) values(#{key}, 'true')")
    int addKey(String key);

}
