package com.blog.service.Impl;

import com.blog.entity.Blog;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogMapper mapper;

    @Override
    public List<Blog> findAllBlog() {
        return mapper.findAllBlog();
    }

    @Override
    public Blog findBlogById(int id) {
        return mapper.findBlogById(id);
    }

    @Override
    public int addBlog(Blog blog) {
        return mapper.addBlog(blog);
    }

    @Override
    public int deleteBlog(int id) {
        return mapper.deleteBlog(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        return mapper.updateBlog(blog);
    }

    @Override
    public List<Blog> findBlogByType(int id) {
        return mapper.findBlogByType(id);
    }

    @Override
    public int addViewBlogById(int id) {
        return mapper.addViewBlogById(id);
    }


}
