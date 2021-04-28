package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.Message;
import com.yygq.vxclass.bean.Vo.MessageVO;
import com.yygq.vxclass.mapper.MessageMapper;
import com.yygq.vxclass.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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
    public List<Message> findByClassId(Integer classId) {
        return messageMapper.findByClassId(classId);
    }

    @Override
    public List<MessageVO> findByUserId(Integer userId) {
        return messageMapper.findByUserId(userId);
    }

    @Override
    public Boolean saveMessage(Message message) {
        return messageMapper.saveMessage(message);
    }
}
