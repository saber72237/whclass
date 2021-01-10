package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Vo.HomeworkVo;

import java.util.Collection;
import java.util.List;

public interface HomeworkService {

    public Collection<HomeworkVo> findById(Integer id);

    public boolean deleteById(Integer id);

    public boolean addById(HomeworkVo homeworkVo);

    public boolean updateById(HomeworkVo homeworkVo);
}
