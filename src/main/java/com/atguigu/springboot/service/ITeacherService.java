package com.atguigu.springboot.service;


import com.atguigu.springboot.bean.Teacher;

public interface ITeacherService {
    public Teacher findByName(String username);

    public Teacher findById(Integer id);
}
