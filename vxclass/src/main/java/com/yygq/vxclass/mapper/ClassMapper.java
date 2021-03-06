package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.Vo.ClassDetailVO;
import com.yygq.vxclass.bean.Vo.ClassSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {

    public ClassDetailVO findById(Integer id);

    public List<ClassSearchVo> findByName(@Param("search") String search);

    public Integer findStatus(ClassDetailVO classDetailVO);

    public List<ClassSearchVo> findToId(Integer id);

    public Integer findByClassId(Integer classId);

    public Integer findByIds(Integer stuId, Integer classId);

    public Boolean insert(Integer stuId, Integer classId);
}
