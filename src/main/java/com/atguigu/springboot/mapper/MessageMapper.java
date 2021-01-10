package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Message;

import java.util.Collection;

public interface MessageMapper {
    public Collection<Message> findById(Integer id);
    public boolean updateById(Message message);
}
