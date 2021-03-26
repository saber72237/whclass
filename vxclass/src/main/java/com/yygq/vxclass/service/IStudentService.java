package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.Student;

public interface IStudentService {

    public Student findByVXId(String stuNo);
}
