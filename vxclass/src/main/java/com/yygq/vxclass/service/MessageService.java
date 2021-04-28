package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.Message;
import com.yygq.vxclass.bean.Vo.MessageVO;

import java.util.List;

public interface MessageService {

    public List<Message> findByClassId(Integer classId);

    public List<MessageVO> findByUserId(Integer userId);

    public Boolean saveMessage(Message message);

}
