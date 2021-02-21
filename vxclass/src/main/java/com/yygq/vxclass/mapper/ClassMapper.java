package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.Vo.ClassSearchVo;

import java.util.List;

public interface ClassMapper {
    public List<ClassSearchVo> findByName(String search);
}
