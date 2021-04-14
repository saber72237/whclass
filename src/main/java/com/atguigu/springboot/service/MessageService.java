package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.bean.Vo.MessageVo;

import java.util.Collection;

public interface MessageService {

    public Collection<MessageVo> findById(Integer id);

    public boolean updateById(Message message);

    public boolean deleteById(Integer id);
}
