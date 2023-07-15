package com.blog.mapper;

import com.blog.entity.Account;
import com.blog.entity.UserMessage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    Account findAccountByUsername(String username);

    @Select("select * from user where username = #{username} and password = #{password}")
    Account findAccountByAccount(Account account);

    @Insert("insert into user(username, password, role) values(#{username}, #{password}, #{role})")
    int addAccount(Account account);

    @Insert("insert into userMessage(uid, nickname, avatar, comment) values(#{uid}, #{nickname}, '../static/images/me.jpg', 0)")
    int initAccountMessage(@Param("uid") int uid, @Param("nickname") String nickname);

    @Select("select * from userMessage where uid = #{uid}")
    UserMessage findAccountMessage(int uid);

    @Update("update usermessage set comment = comment+1 where uid = #{uid}")
    int addMessageComment(int uid);

    @Update("update usermessage set comment = 0 where uid = #{uid}")
    int deleteMessageComment(int uid);

    @Update("update usermessage set nickname = #{nickname} where uid = #{uid}")
    int updateNickname(UserMessage message);

    @Update("update usermessage set avatar = #{avatar} where uid = #{uid}")
    int updateAvatar(UserMessage message);

}
