package com.blog.service;

import com.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    int addCommentByMessage(Comment comment);

    int deleteComment(int id);

    void addRootCommentByMessage(Comment comment,int id);

    List<Comment> findAllCommentByBlog(int id);

    List<Comment> findAllComment();

    List<Comment> findRootCommentByUid(int uid);

    int updateAvatar(String avatar, int uid);

    int updateNickname(String username, int uid);

}
