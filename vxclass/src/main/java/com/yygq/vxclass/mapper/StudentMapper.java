package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.Student;

public interface StudentMapper {

    public Student findByVXId(String vxId);

    public Boolean setStuNo(String stuNo, String vxId);
}
