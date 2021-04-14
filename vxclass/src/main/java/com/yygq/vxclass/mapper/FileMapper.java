package com.yygq.vxclass.mapper;

import com.yygq.vxclass.bean.File;
import com.yygq.vxclass.bean.Vo.FileVo;

import java.util.List;

public interface FileMapper {
    public Boolean saveHomework(File homework);

    public List<FileVo> history(Integer id);
}
