package com.blog.mapper;

import com.blog.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Insert("insert into t_type(name) values(#{name})")
    int addType(String name);

    @Update("update t_type set name = #{name} where id = #{id}")
    int updateType(Type type);

    @Delete("delete from t_type where id = #{id}")
    int deleteType(int id);

    @Select("SELECT t.id, t.name, COUNT(b.type_id) AS count FROM t_type t LEFT JOIN t_blog b ON t.id = b.type_id GROUP BY t.id, t.name")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "count", property = "count")
    })
    List<Type> findAllType();

    @Select("SELECT * FROM t_type where id = #{id}")
    Type findTypeById(int id);

}
