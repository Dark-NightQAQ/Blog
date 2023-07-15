package com.blog.controller;

import com.blog.entity.UserMessage;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class proFileController {

    @Resource
    UserService service;

    @Resource
    CommentService commentService;

    @GetMapping("/profile")
    public String proFile(HttpSession session){
        UserMessage account = (UserMessage) session.getAttribute("account");
        if(account == null){
            return "redirect:/index";
        }
        return "profile";
    }

    @PostMapping("/profile/avatar")
    public String avatar(String avatar, HttpSession session){
        String text = "https://q1.qlogo.cn/g?b=qq&nk="+avatar+"&s=640";
        UserMessage account = (UserMessage) session.getAttribute("account");
        account.setAvatar(text);
        service.updateAvatar(account);
        commentService.updateAvatar(text, account.getUid());
        session.setAttribute("account", account);
        return "redirect:/profile";
    }

    @PostMapping("/profile/username")
    public String nickname(String username, HttpSession session){
        UserMessage account = (UserMessage) session.getAttribute("account");
        username = username.trim();
        account.setNickname(username);
        service.updateNickname(account);
        commentService.updateNickname(username, account.getUid());
        session.setAttribute("account", account);
        return "redirect:/profile";
    }
}
