package com.yygq.vxclass.service;

import com.yygq.vxclass.bean.File;
import com.yygq.vxclass.bean.Vo.FileVo;

import java.util.List;

public interface FileService {

    public Boolean saveHomework(File homework );

    public List<FileVo> history(Integer id);

}
