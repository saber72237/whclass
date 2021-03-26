package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Message;

import java.util.Collection;

public interface MessageService {

    public Collection<Message> findById(Integer id);

    public boolean updateById(Message message);

    public boolean deleteById(Integer id);
}
