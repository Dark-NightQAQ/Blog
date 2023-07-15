package com.blog.service;

import com.blog.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeService {
    List<Type> findAllType();

    int addType(String name);

    int updateType(Type type);

    int deleteType(int id);

    Type findTypeById(int id);
}
