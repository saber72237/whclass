package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Vo.ClassSearchVo;
import com.atguigu.springboot.mapper.ClassMapper;
import com.atguigu.springboot.service.ClassService;
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
    public Collection<Class> findById(Integer id) {
        return classMapper.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return classMapper.deleteById(id);
    }

    @Override
    public boolean addById(Class classes) {
        return classMapper.addById(classes);
    }

    @Override
    public boolean updateById(Class classes) {
        return classMapper.updateById(classes);
    }

    public List<ClassSearchVo> findByName(String search){
        return classMapper.findByName(search);
    }
}
