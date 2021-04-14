package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.Student;
import com.yygq.vxclass.mapper.StudentMapper;
import com.yygq.vxclass.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c)2021
 *
 * @author: liuguanzhong
 * @date:
 * @time:
 * @description:
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student findByVXId(String vxId){
        return studentMapper.findByVXId(vxId);
    }

    @Override
    public Boolean setStuNo(String stuNo, String vxId) {
        return studentMapper.setStuNo(stuNo, vxId);
    }
}
