package com.blog.controller;

import com.blog.service.BlogService;
import com.blog.service.TypeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TypeController {

    @Resource
    BlogService blogService;

    @Resource
    TypeService service;

    @GetMapping("/type")
    public String type(Model model){
        model.addAttribute("Types", service.findAllType());
        model.addAttribute("blog", blogService.findAllBlog());
        return "types";
    }

    @GetMapping("/type/{id}")
    public String type(@PathVariable String id,
                       Model model){
        model.addAttribute("Types", service.findAllType());
        model.addAttribute("blog", blogService.findBlogByType(Integer.parseInt(id)));
        return "types";
    }


}
