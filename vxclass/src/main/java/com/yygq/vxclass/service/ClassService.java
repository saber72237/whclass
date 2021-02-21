package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.Vo.ClassSearchVo;

import java.util.Collection;
import java.util.List;

public interface ClassService {
    public List<ClassSearchVo> findByName(String search);
}
