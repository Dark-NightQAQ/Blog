package com.blog.service.Impl;

import com.blog.entity.Type;
import com.blog.mapper.TypeMapper;
import com.blog.service.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    TypeMapper mapper;

    @Override
    public List<Type> findAllType() {
        return mapper.findAllType();
    }

    @Override
    public int addType(String name) {
        return mapper.addType(name);
    }

    @Override
    public int updateType(Type type) {
        return mapper.updateType(type);
    }

    @Override
    public int deleteType(int id) {
        return mapper.deleteType(id);
    }

    @Override
    public Type findTypeById(int id) {
        return mapper.findTypeById(id);
    }
}
