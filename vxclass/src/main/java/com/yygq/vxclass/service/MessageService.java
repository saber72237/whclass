package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.Message;

import java.util.List;

public interface MessageService {

    public List<Message> findByClassId(Integer classId);

    public Boolean saveMessage(Message message);

}
