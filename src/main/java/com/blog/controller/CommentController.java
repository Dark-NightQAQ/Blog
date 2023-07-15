package com.blog.controller;

import com.blog.entity.Account;
import com.blog.entity.Comment;
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
public class CommentController {

    @Resource
    CommentService service;

    @Resource
    UserService userService;

    @PostMapping("/commentMessage/{blog}")
    public String comment(String content, Comment comment, HttpSession session, @PathVariable String blog){
        if(content.trim().isEmpty()){
            return "redirect:/message";
        }
        UserMessage account = (UserMessage) session.getAttribute("account");
        comment.setUid(account.getUid());
        comment.setContent(content);
        comment.setNickname(account.getNickname());
        comment.setBlogId(Long.parseLong(blog));
        comment.setAvatar(account.getAvatar());
        service.addCommentByMessage(comment);
        if(blog.equals("666")){
            return "redirect:/message";
        }else {
            return "redirect:/Blog/"+blog;
        }

    }

    @GetMapping("/deleteComment/{Blog}/{id}")
    public String deleteComment(@PathVariable String id, @PathVariable String Blog){
        service.deleteComment(Integer.parseInt(id));
        if(Blog.equals("666")){
            return "redirect:/message";
        }else{
            return "redirect:/Blog/"+Blog;
        }
    }

    @GetMapping("/replyComment/{Blog}/{id}/{uid}/{reply}")
    public String replyComment(HttpSession session, @PathVariable String Blog, @PathVariable String id,@PathVariable String uid, @PathVariable String reply, Comment
                                comment){
        UserMessage account = (UserMessage) session.getAttribute("account");
        comment.setUid(account.getUid());
        comment.setAvatar(account.getAvatar());
        comment.setBlogId(Long.parseLong(Blog));
        comment.setNickname(account.getNickname());
        comment.setContent(reply);
        service.addRootCommentByMessage(comment, Integer.parseInt(id));
        userService.addMessageComment(Integer.parseInt(uid));
        if(Blog.equals("666")){
            return "redirect:/message";
        }else{
            return "redirect:/Blog/"+Blog;
        }
    }

}
