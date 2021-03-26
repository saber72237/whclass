package com.yygq.vxclass.service;


import com.yygq.vxclass.bean.Doc;
import com.yygq.vxclass.bean.Doclist;
import com.yygq.vxclass.bean.Vo.ClassDocVo;

import java.util.Collection;
import java.util.List;

public interface IDocService {

    public Collection<Doclist> findByClassId(Integer classId);

    public Integer editPassword1(Integer id, String password);

    public Integer editPassword2(Integer id, String password);

    public boolean deleteById(Integer id);

    public boolean addById(Doclist doclist);

    public boolean updateById(Doclist doclist);

    public List<Doclist> findByName(String search);

    public List<ClassDocVo> getList(String prefixId);

    public List<ClassDocVo> getDocList(String prefixId);

    public Integer findById1(Integer id);

    public Integer findById2(Integer id);

    public Boolean saveDoclist(Doclist doclist);

    public Doc findDoc(Integer id);
}
