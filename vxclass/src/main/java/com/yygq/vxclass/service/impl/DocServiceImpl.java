package com.yygq.vxclass.service.impl;

import com.yygq.vxclass.bean.Doc;
import com.yygq.vxclass.bean.Doclist;
import com.yygq.vxclass.bean.Vo.ClassDocVo;
import com.yygq.vxclass.mapper.DocMapper;
import com.yygq.vxclass.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Copyright: Copyright (c)2021
 *
 * @author: liuguanzhong
 * @date:
 * @time:
 * @description:
 */
@Service
public class DocServiceImpl implements IDocService {

    @Autowired
    DocMapper docMapper;

    @Override
    public Collection<Doclist> findByClassId(Integer classId) {
        return docMapper.findByClassId(classId);
    }

    @Override
    public Integer editPassword1(Integer id, String password) {
        return docMapper.editPassword1(id, password);
    }

    @Override
    public Integer editPassword2(Integer id, String password) {
        return docMapper.editPassword2(id, password);
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean addById(Doclist doclist) {
        return false;
    }

    @Override
    public boolean updateById(Doclist doclist) {
        return false;
    }

    @Override
    public List<Doclist> findByName(String search) {
        return null;
    }

    @Override
    public List<ClassDocVo> getList(String prefixId) {
        return docMapper.getList(prefixId);
    }

    @Override
    public List<ClassDocVo> getDocList(String prefixId) {
        return docMapper.getDocList(prefixId);
    }

    @Override
    public Integer findById1(Integer id) {
        return docMapper.findById1(id);
    }

    @Override
    public Integer findById2(Integer id) {
        return docMapper.findById2(id);
    }

    @Override
    public Boolean saveDoclist(Doclist doclist) {
        return docMapper.saveDoclist(doclist);
    }

    @Override
    public Doc findDoc(Integer id) {
        return docMapper.findDoc(id);
    }
}
