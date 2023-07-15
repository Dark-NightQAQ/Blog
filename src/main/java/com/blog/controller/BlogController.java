package com.blog.controller;

import com.blog.service.BlogService;
import com.blog.service.CommentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    @Resource
    BlogService service;

    @Resource
    CommentService commentService;

    @GetMapping("/Blog/{id}")
    public String readBlog(@PathVariable String id,
                           Model model){
        model.addAttribute("comment",commentService.findAllCommentByBlog(Integer.parseInt(id)));
        model.addAttribute("Blog", service.findBlogById(Integer.parseInt(id)));
        service.addViewBlogById(Integer.parseInt(id));
        return "blog";
    }

    @PostMapping("/Blog/{id}")
    public String ReadBlog(@PathVariable String id,
                           Model model){
        model.addAttribute("comment",commentService.findAllCommentByBlog(Integer.parseInt(id)));
        model.addAttribute("Blog", service.findBlogById(Integer.parseInt(id)));
        service.addViewBlogById(Integer.parseInt(id));
        return "blog";
    }



}
