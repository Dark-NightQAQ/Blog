package com.blog.controller;

import com.blog.entity.UserMessage;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class replyController {

    @Resource
    CommentService service;

    @Resource
    UserService userService;

    @GetMapping("/replyView")
    public String replyView(Model model, HttpSession session){
        UserMessage account = (UserMessage) session.getAttribute("account");
        if(account == null){
            return "redirect:/index";
        }
        model.addAttribute("comments", service.findRootCommentByUid(account.getUid()));
        userService.deleteMessageComment(account.getUid());
        session.setAttribute("account", userService.findAccountMessage(account.getUid()));
        return "reply";
    }

}
