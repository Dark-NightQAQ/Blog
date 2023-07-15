package com.blog.service.Impl;

import com.blog.entity.Account;
import com.blog.entity.UserMessage;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements UserDetailsService, UserService {
    @Resource
    UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = mapper.findAccountByUsername(username);
        if(account == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

    @Override
    public Account findAccountByUsername(String username) {
        return mapper.findAccountByUsername(username);
    }

    @Override
    public int addAccount(Account account) {
        return mapper.addAccount(account);
    }

    @Override
    public int initAccountMessage(int uid, String nickname) {
        return mapper.initAccountMessage(uid, nickname);
    }

    @Override
    public UserMessage findAccountMessage(int uid) {
        return mapper.findAccountMessage(uid);
    }

    @Override
    public int addMessageComment(int uid) {
        return mapper.addMessageComment(uid);
    }

    @Override
    public int deleteMessageComment(int uid) {
        return mapper.deleteMessageComment(uid);
    }

    @Override
    public int updateNickname(UserMessage message) {
        return mapper.updateNickname(message);
    }

    @Override
    public int updateAvatar(UserMessage message) {
        return mapper.updateAvatar(message);
    }
}
