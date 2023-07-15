package com.blog.entity;

import lombok.Data;

@Data
public class UserMessage {
    int id;
    int uid;
    String nickname;
    String avatar;
    int comment;
}
