package com.blog.service;

import com.blog.entity.Key;

import java.util.List;

public interface keyService {

    List<Key> findAllKey();

    int updateKey(String key);

    int addKey(String key);
}
