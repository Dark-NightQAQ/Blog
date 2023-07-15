package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Type;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import com.blog.service.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    BlogService service;

    @Resource
    TypeService typeService;

    @Resource
    CommentService commentService;

    @GetMapping({"/index","/*","/"})
    public String index(Model model){
        model.addAttribute("AllBlog", service.findAllBlog());
        return "/admin/index";
    }
    @GetMapping("/login")
    public String login(){
        return "/admin/login";
    }

    @GetMapping("/addBlog")
    public String addBlog(Model model){
        model.addAttribute("types", typeService.findAllType());
        return "/admin/addBlog";
    }

    @PostMapping("/addBlog")
    public String AddBlog(String title, String content, String typeId, String firstPicture, String description){
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setTypeName(typeId);
        blog.setFirstPicture(firstPicture);
        blog.setDescription(description);
        service.addBlog(blog);
        return "redirect:/admin/index";
    }

    @GetMapping("/updateBlog/{id}")
    public String updateBlog(@PathVariable String id,
                             Model model){
        model.addAttribute("types",typeService.findAllType());
        model.addAttribute("blog", service.findBlogById(Integer.parseInt(id)));
        return "/admin/updateBlog";
    }

    @PostMapping("/UpdateBlog/{id}")
    public String updateBlog(String title, String content, String typeId, String firstPicture, String description, @PathVariable String id){
        Blog blog = new Blog();
        blog.setId(Long.parseLong(id));
        blog.setTitle(title);
        blog.setContent(content);
        blog.setTypeName(typeId);
        blog.setFirstPicture(firstPicture);
        blog.setDescription(description);
        service.updateBlog(blog);
        return "redirect:/admin/index";
    }

    @GetMapping("/types")
    public String types(Model model){
        model.addAttribute("types", typeService.findAllType());
        return "/admin/type";
    }

    @GetMapping("/addType")
    public String addType(){
        return "/admin/addType";
    }

    @PostMapping("/addType")
    public String addType(String name){
        typeService.addType(name);
        return "redirect:/admin/types";
    }

    @GetMapping("/updateType/{id}")
    public String updateType(@PathVariable String id,
                             Model model){
        model.addAttribute("Type", typeService.findTypeById(Integer.parseInt(id)));
        return "/admin/updateType";
    }

    @PostMapping("/UpdateType/{id}")
    public String updateType(@PathVariable String id, String name){
        Type type = new Type();
        type.setId(Long.parseLong(id));
        type.setName(name);
        typeService.updateType(type);
        return "redirect:/admin/types";
    }

    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable String id){
        typeService.deleteType(Integer.parseInt(id));
        return "redirect:/admin/types";
    }

    @GetMapping("/comment")
    public String comment(Model model){
        model.addAttribute("comment",commentService.findAllComment());
        return "/admin/comment";
    }

    @GetMapping("/deleteComment/{id}")
    public String comment(@PathVariable String id){
        commentService.deleteComment(Integer.parseInt(id));
        return "redirect:/admin/comment";
    }

    @GetMapping("/admin/deleteBlog/{id}")
    public String deleteBlog(@PathVariable String id){
        service.deleteBlog(Integer.parseInt(id));
        return "redirect:/admin/index";
    }

}
