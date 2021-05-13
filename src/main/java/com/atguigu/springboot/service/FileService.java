package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.File1;
import com.atguigu.springboot.bean.Vo.FileVo;

import java.util.Collection;

public interface FileService {
    public Collection<FileVo> findById(Integer id);
    public boolean updateById(File1 file);
}
