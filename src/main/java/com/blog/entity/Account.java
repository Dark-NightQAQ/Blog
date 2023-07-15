package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    int id;
    String username;
    String password;
    String role;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
