package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.Vo.ClassSearchVo;
import com.yygq.vxclass.mapper.ClassMapper;
import com.yygq.vxclass.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 13:05
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<ClassSearchVo> findByName(String search) {
        return classMapper.findByName(search);
    }
}
