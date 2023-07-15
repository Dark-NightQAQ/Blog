package com.blog.controller;

import com.blog.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Resource
    BlogService service;

    @GetMapping({"/index","/*"})
    public String index(Model model){
        model.addAttribute("AllBlog", service.findAllBlog());
        return "index";
    }

    @PostMapping("/index")
    public String Index(Model model){
        model.addAttribute("AllBlog", service.findAllBlog());
        return "index";
    }

}
