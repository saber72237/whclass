package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.Teacher;
import com.atguigu.springboot.mapper.TeacherMapper;
import com.atguigu.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2020/12/31 8:58
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findByName(String username) {
        return teacherMapper.findByName(username);
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherMapper.findById(id);
    }
}
