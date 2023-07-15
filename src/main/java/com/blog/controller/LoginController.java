package com.blog.controller;

import com.blog.entity.Account;
import com.blog.service.Impl.AuthServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Resource
    AuthServiceImpl service;

    @GetMapping("/uLogin")
    public String login(){
        return "login&register";
    }

    @PostMapping("/Login")
    public String login(String username, String password, HttpSession session, Model model){
        Account account = service.findAccountByUsername(username);
        if(account == null || !new BCryptPasswordEncoder().matches(password,account.getPassword())){
            model.addAttribute("error", "账号或密码有错！请重新输入！");
            return "error";
        }
        session.setAttribute("account", service.findAccountMessage(account.getId()));
        session.setAttribute("isLogin", true);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
