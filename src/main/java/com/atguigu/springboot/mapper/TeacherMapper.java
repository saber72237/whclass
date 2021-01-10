package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Teacher;

public interface TeacherMapper {
    public Teacher findByName(String username);

    public Teacher findById(Integer id);
}
