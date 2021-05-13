package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.File1;
import com.atguigu.springboot.bean.Message;
import com.atguigu.springboot.bean.Vo.FileVo;

import java.util.Collection;

public interface FileMapper {
    public Collection<FileVo> findById(Integer id);
    public boolean updateById(File1 file);
}
