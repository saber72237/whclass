package com.atguigu.springboot.mapper;


import com.atguigu.springboot.bean.Doclist;
import com.atguigu.springboot.bean.Vo.ClassDocVo;

import java.util.Collection;
import java.util.List;

public interface DocMapper {
    public Collection<Doclist> findById(Integer id);
    public Boolean editPassword1(Integer id, String password);
    public Boolean editPassword2(Integer id, String password);
    public boolean deleteById1(Integer id);
    public boolean deleteById2(Integer id);
    public boolean addById(Doclist doclist);
    public boolean updateById(Doclist doclist);
    public List<Doclist> findByName(String search);
    public List<ClassDocVo> getList(String prefixId);
    public List<ClassDocVo> getDocList(String prefixId);
    public Boolean saveDoclist(Doclist doclist);
}
