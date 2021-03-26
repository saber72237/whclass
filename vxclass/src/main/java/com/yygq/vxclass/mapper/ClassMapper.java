package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.Vo.ClassDetailVO;
import com.yygq.vxclass.bean.Vo.ClassSearchVo;

import java.util.List;

public interface ClassMapper {

    public ClassDetailVO findById(Integer id);

    public List<ClassSearchVo> findByName(String search);

    public Integer findStatus(ClassDetailVO classDetailVO);

    public List<ClassSearchVo> findToId(Integer id);

    public Integer findByClassId(Integer classId);
}
