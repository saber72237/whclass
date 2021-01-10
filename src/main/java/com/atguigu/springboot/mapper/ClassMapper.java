package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Vo.HomeworkVo;

import java.util.Collection;

public interface ClassMapper {
    public Collection<Class> findById(Integer id);
    public boolean deleteById(Integer id);
    public boolean addById(Class classes);
    public boolean updateById(Class classes);
}
