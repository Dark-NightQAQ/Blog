package com.blog.service;

import com.blog.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    Blog findBlogById(int id);

    int addBlog(Blog blog);

    int deleteBlog(int id);

    int updateBlog(Blog blog);

    List<Blog> findBlogByType(int id);

    int addViewBlogById(int id);
}
