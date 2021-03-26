package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.Homework;

import java.util.List;

public interface HomeworkMapper {

    public List<Homework> findByClassId(Integer classId);

    public Homework findById(Integer id);

}
