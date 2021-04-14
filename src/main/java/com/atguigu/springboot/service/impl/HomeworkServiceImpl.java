package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.Vo.HomeworkVo;
import com.atguigu.springboot.mapper.HomeworkMapper;
import com.atguigu.springboot.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/3 14:14
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    HomeworkMapper homeworkMapper;

    @Override
    public Collection<HomeworkVo> findById(Integer id) {
        return homeworkMapper.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return homeworkMapper.deleteById(id);
    }

    @Override
    public boolean addById(HomeworkVo homeworkVo) {
        if (homeworkVo.getMonth().length() == 1){
            homeworkVo.setMonth("0" + homeworkVo.getMonth());
        }
        if (homeworkVo.getDay().length() == 1){
            homeworkVo.setDay("0" + homeworkVo.getDay());
        }
        homeworkVo.setTime(homeworkVo.getYear() + "-" + homeworkVo.getMonth() + "-" + homeworkVo.getDay() + " " + "10:00:00");
        return homeworkMapper.addById(homeworkVo);
    }

    @Override
    public boolean updateById(HomeworkVo homeworkVo) {
        return homeworkMapper.updateById(homeworkVo);
    }
}
