package com.blog.mapper;

import com.blog.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select id, uid, nickname, content, avatar, create_time, blog_id from t_comment where blog_id = #{id} and parent_comment_id is null order by create_time desc")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "content", property = "content"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "blog_id",property = "blogId"),
            @Result(column = "id", property = "rootComment", javaType = List.class, many = @Many(select = "findRootCommentByBlog"))
    })
    List<Comment> findAllCommentByBlog(int id);

    @Select("select id, uid, nickname, content, avatar, create_time, blog_id from t_comment")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "content", property = "content"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "blog_id",property = "blogId"),
    })
    List<Comment> findAllComment();

    @Select("SELECT * FROM t_comment WHERE parent_comment_id = #{parentId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "content", property = "content"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "blog_id",property = "blogId"),
    })
    List<Comment> findRootCommentByBlog(@Param("parentId") int parentId);


    @Insert("insert into t_comment(uid, nickname, content, avatar, create_time, blog_id) values(#{uid}, #{nickname}, #{content}, #{avatar}, now(), #{blogId})")
    int addComment(Comment comment);

    @Insert("insert into t_comment(uid, nickname, content, avatar, create_time, blog_id, parent_comment_id) values(#{comment.uid}, #{comment.nickname}, #{comment.content}, #{comment.avatar}, now(), #{comment.blogId}, #{parentId})")
    void addRootComment(@Param("comment") Comment comment, @Param("parentId") int id);

    @Delete("delete from t_comment where id = #{id}")
    int deleteComment(int id);

    @Select("select * from t_comment where parent_comment_id in (select id from t_comment where uid = #{uid}) order by create_time desc")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "content", property = "content"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "blog_id",property = "blogId"),
            @Result(column = "parent_comment_id",property = "parentComment", javaType = Comment.class, one = @One(select = "findParentCommentByBlog"))
    })
    List<Comment> findRootCommentByUid(int uid);

    @Select("select * from t_comment where id = #{id}")
    List<Comment> findParentCommentByBlog(@Param("id") int id);

    @Update("update t_comment set nickname = #{username} where uid = #{uid}")
    int updateNickname(@Param("username") String username, @Param("uid") int uid);

    @Update("update t_comment set avatar = #{avatar} where uid = #{uid}")
    int updateAvatar(@Param("avatar") String avatar, @Param("uid") int uid);
}
