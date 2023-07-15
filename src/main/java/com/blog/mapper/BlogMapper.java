package com.blog.mapper;

import com.blog.entity.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Select("select b.id, b.title, b.content, b.description,b.first_picture,b.views,b.comment_count,b.create_time,t.name from t_blog b left join t_type t on b.type_id = t.id where b.id != 666 order by b.create_time desc")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "description", property = "description"),
            @Result(column = "first_picture",property = "firstPicture"),
            @Result(column = "views", property = "views"),
            @Result(column = "comment_count",property = "commentCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "name",property = "typeName")
    })
    List<Blog> findAllBlog();

    @Select("select b.id, b.title, b.content, b.description,b.first_picture,b.views,b.comment_count,b.create_time,t.name  from t_blog b left join t_type t on b.type_id = t.id where b.id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "description", property = "description"),
            @Result(column = "first_picture",property = "firstPicture"),
            @Result(column = "views", property = "views"),
            @Result(column = "comment_count",property = "commentCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "name",property = "typeName")
    })
    Blog findBlogById(int id);

    @Insert("insert into t_blog(title, content, description, first_picture, views, comment_count, create_time, type_id) value(#{title},#{content},#{description},#{firstPicture},0,0,now(),(select id from t_type where name = #{typeName}))")
    int addBlog(Blog blog);

    @Delete("delete from t_blog where id = #{id}")
    int deleteBlog(int id);

    @Update("UPDATE t_blog set title = #{title}, content = #{content}, description = #{description}, first_picture = #{firstPicture}, type_id = (select id from t_type where name = #{typeName}) where id = #{id};")
    int updateBlog(Blog blog);

    @Select("select b.id, b.title, b.content, b.description,b.first_picture,b.views,b.comment_count,b.create_time,t.name  from t_blog b left join t_type t on b.type_id = t.id where t.id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "description", property = "description"),
            @Result(column = "first_picture",property = "firstPicture"),
            @Result(column = "views", property = "views"),
            @Result(column = "comment_count",property = "commentCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "name",property = "typeName")
    })
    List<Blog> findBlogByType(int id);

    @Update("UPDATE t_blog set views = views+1 where id = #{id}")
    int addViewBlogById(int id);
}
