package com.blog.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private Long id;
    private int uid;
    private String nickname;
    private String content;
    private String avatar;
    private String createTime;
    private Long blogId;
    private List<Comment> rootComment;
    private Comment parentComment;
}
