package com.blog.controller;

import com.blog.entity.Account;
import com.blog.entity.Key;
import com.blog.service.UserService;
import com.blog.service.keyService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class registerController {

    @Resource
    keyService service;

    @Resource
    UserService userService;

    @PostMapping("/register")
    public String register(String username, String password, String key){
        Account account = userService.findAccountByUsername(username);
        if(account != null){
            return "redirect:/cantRegister";
        }
        List<Key> allKey = service.findAllKey();
        for(int i = 0; i< allKey.size();i++){
            if(allKey.get(i).getKey().equals(key)){
                Account user = new Account();
                user.setUsername(username);
                user.setPassword(new BCryptPasswordEncoder().encode(password));
                user.setRole("user");
                userService.addAccount(user);
                userService.initAccountMessage(userService.findAccountByUsername(username).getId(), user.getUsername());
                service.updateKey(key);
                return "redirect:/uLogin";
            }
        }
        return "redirect:/neverKey";
    }

    @GetMapping("/cantRegister")
    public String cant(Model model){
        model.addAttribute("error", "该账号已被注册！");
        return "error";
    }

    @GetMapping("/neverKey")
    public String cantKey(Model model){
        model.addAttribute("error", "密钥不存在或已被使用！");
        return "error";
    }

}
