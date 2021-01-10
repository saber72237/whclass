package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.File;
import com.atguigu.springboot.bean.Vo.FileVo;
import com.atguigu.springboot.mapper.FileMapper;
import com.atguigu.springboot.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/8 20:23
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public Collection<FileVo> findById(Integer id) {
        return fileMapper.findById(id);
    }

    @Override
    public boolean updateById(File file) {
        return fileMapper.updateById(file);
    }
}
