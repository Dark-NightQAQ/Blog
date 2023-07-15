package com.blog.service.Impl;

import com.blog.entity.Key;
import com.blog.mapper.KeyMapper;
import com.blog.service.keyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class keyServiceImpl implements keyService {

    @Resource
    KeyMapper mapper;

    @Override
    public List<Key> findAllKey() {
        return mapper.findAllKey();
    }

    @Override
    public int updateKey(String key) {
        return mapper.updateKey(key);
    }

    @Override
    public int addKey(String key) {
        return mapper.addKey(key);
    }
}
