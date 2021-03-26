package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.File;
import com.yygq.vxclass.mapper.FileMapper;
import com.yygq.vxclass.service.FileService;
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
    public Boolean saveHomework(File homework) {
        return fileMapper.saveHomework(homework);
    }
}
