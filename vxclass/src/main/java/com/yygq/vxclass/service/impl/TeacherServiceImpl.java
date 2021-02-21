package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.mapper.TeacherMapper;
import com.yygq.vxclass.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/12/31 8:58
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    TeacherMapper teacherMapper;

}
