package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.Vo.ClassDetailVO;
import com.yygq.vxclass.bean.Vo.ClassSearchVo;

import java.util.Collection;
import java.util.List;

public interface ClassService {

    public ClassDetailVO findById(Integer id);

    public List<ClassSearchVo> findByName(String search);

    public List<ClassSearchVo> findToId(Integer id);

    public Integer findStatus(ClassDetailVO classDetailVO);

    public Integer findByClassId(Integer classId);

    public Boolean updateState(Boolean flag, Integer stuId, Integer classId);
}
