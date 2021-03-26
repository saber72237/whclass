package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.Homework;

import java.util.List;

public interface HomeworkService {

    public List<Homework>  findByClassId(Integer classId);

    public Homework  findById(Integer id);

}
