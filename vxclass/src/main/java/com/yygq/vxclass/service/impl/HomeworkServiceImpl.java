package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.Homework;
import com.yygq.vxclass.mapper.HomeworkMapper;
import com.yygq.vxclass.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/3 14:14
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    HomeworkMapper homeworkMapper;

    @Override
    public List<Homework> findByClassId(Integer classId) {
        return homeworkMapper.findByClassId(classId);
    }

    @Override
    public Homework findById(Integer id) {
        return homeworkMapper.findById(id);
    }
}
