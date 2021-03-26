package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.Message;

import java.util.List;

public interface MessageMapper {

    public List<Message> findByClassId(Integer classId);

    public Boolean saveMessage(Message message);

}
