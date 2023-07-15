package com.blog.controller;

import com.blog.service.keyService;
import com.blog.util.KeyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KeyController {

    @Resource
    keyService service;

    @GetMapping("/admin/createKey")
    public String addKey(){
        for(int i = 0; i < 3; i++){
            service.addKey(KeyUtil.CreateNewKey());
        }
        return "redirect:/admin/key";
    }

    @GetMapping("/admin/key")
    public String showKey(Model model){
        model.addAttribute("keys", service.findAllKey());
        return "/admin/key";
    }

}
