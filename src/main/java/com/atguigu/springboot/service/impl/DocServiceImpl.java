package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.bean.Doclist;
import com.atguigu.springboot.bean.Vo.ClassDocVo;
import com.atguigu.springboot.mapper.DocMapper;
import com.atguigu.springboot.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
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
    public Collection<Doclist> findById(Integer id) {
        return docMapper.findById(id);
    }

    @Override
    public Boolean editPassword1(Integer id, String password) {
        return docMapper.editPassword1(id, password);
    }

    @Override
    public Boolean editPassword2(Integer id, String password) {
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
    public Boolean saveDoclist(Doclist doclist) {
        return docMapper.saveDoclist(doclist);
    }
}
