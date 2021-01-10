package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Vo.HomeworkVo;

import java.util.Collection;

public interface ClassService {

    public Collection<Class> findById(Integer id);

    public boolean deleteById(Integer id);

    public boolean addById(Class classes);

    public boolean updateById(Class classes);
}
