package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.mapper.MessageMapper;
import com.atguigu.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 17:39
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public Collection<Message> findById(Integer id) {
        return messageMapper.findById(id);
    }

    @Override
    public boolean updateById(Message message) {
        return messageMapper.updateById(message);
    }
}
