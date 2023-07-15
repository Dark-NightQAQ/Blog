package com.blog.service;

import com.blog.entity.Account;
import com.blog.entity.UserMessage;

public interface UserService {

    Account findAccountByUsername(String username);

    int addAccount(Account account);

    int initAccountMessage(int uid, String nickname);

    UserMessage findAccountMessage(int uid);

    int addMessageComment(int uid);

    int deleteMessageComment(int uid);

    int updateNickname(UserMessage message);

    int updateAvatar(UserMessage message);
}
