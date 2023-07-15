package com.blog.service.Impl;

import com.blog.entity.Comment;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper mapper;

    @Override
    public int addCommentByMessage(Comment comment) {
        return mapper.addComment(comment);
    }

    @Override
    public int deleteComment(int id){
        return mapper.deleteComment(id);
    }

    @Override
    public void addRootCommentByMessage(Comment comment, int id) {
        mapper.addRootComment(comment, id);
    }

    @Override
    public List<Comment> findAllCommentByBlog(int id) {
        return mapper.findAllCommentByBlog(id);
    }

    @Override
    public List<Comment> findAllComment() {
        return mapper.findAllComment();
    }

    @Override
    public List<Comment> findRootCommentByUid(int uid) {
        return mapper.findRootCommentByUid(uid);
    }

    @Override
    public int updateAvatar(String avatar, int uid) {
        return mapper.updateAvatar(avatar, uid);
    }

    @Override
    public int updateNickname(String username, int uid) {
        return mapper.updateNickname(username, uid);
    }
}
