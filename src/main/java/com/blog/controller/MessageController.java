package com.blog.controller;

import com.blog.service.CommentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @Resource
    CommentService service;

    @GetMapping("/message")
    public String message( Model model){
        model.addAttribute("comment",service.findAllCommentByBlog(666));
        return "message";
    }

    @PostMapping("/message")
    public String Message(Model model){
        model.addAttribute("comment",service.findAllCommentByBlog(666));
        return "message";
    }
}
