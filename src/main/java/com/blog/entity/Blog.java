package com.blog.entity;

import lombok.Data;

@Data
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String description;
    private String firstPicture;
    private String createTime;
    private Integer views;
    private Integer commentCount;
    private String typeName;
}
