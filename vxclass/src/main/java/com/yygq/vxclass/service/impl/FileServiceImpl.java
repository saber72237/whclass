package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.File;
import com.yygq.vxclass.bean.Vo.FileVo;
import com.yygq.vxclass.mapper.FileMapper;
import com.yygq.vxclass.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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
    public Boolean saveHomework(File homework) {
        return fileMapper.saveHomework(homework);
    }

    @Override
    public List<FileVo> history(Integer id) {
        return fileMapper.history(id);
    }

    @Override
    public Integer getTeacherId(String homeworkId) {
        return fileMapper.getTeacherId(homeworkId);
    }
}
