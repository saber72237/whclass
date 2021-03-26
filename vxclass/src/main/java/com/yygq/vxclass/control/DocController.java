package com.yygq.vxclass.control;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.yygq.vxclass.bean.Doc;
import com.yygq.vxclass.bean.Doclist;
import com.yygq.vxclass.bean.Vo.ClassDocVo;
import com.yygq.vxclass.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
@Controller
@RequestMapping("/doc")
public class DocController {
    @Autowired
    IDocService iDocService;

    @ResponseBody
    @GetMapping("/docList")
    public Collection<Doclist> list(Model model, HttpSession session, String classId){
        Collection<Doclist> doclists = iDocService.findByClassId(Integer.valueOf(classId));
        model.addAttribute("emps",doclists);
        return doclists;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<ClassDocVo> docList(String prefixId){
        Integer check = iDocService.findById1(Integer.valueOf(prefixId));
        List<ClassDocVo> doclists = iDocService.getList(prefixId);
        List<ClassDocVo> docs = iDocService.getDocList(prefixId);
        doclists.addAll(docs);
        if (check > 0){
            return null;
        }
        return doclists;
    }

    @ResponseBody
    @PostMapping("/checkPassword")
    public Boolean checkPassword(@RequestBody Doclist doclist){
        Integer num = null;
            if (StrUtil.isEmpty(doclist.getPath())){
                num = iDocService.editPassword1(doclist.getId(), doclist.getPassword());
            }
            else {
                num = iDocService.editPassword2(doclist.getId(), doclist.getPassword());
            }
            if (num > 0){
                return true;
            }
        return false;
    }


    @GetMapping("/search")
    @ResponseBody
    public List<Doclist> classSearch(String search){
        List<Doclist> classSearchVoList = new ArrayList<Doclist>();
        classSearchVoList = iDocService.findByName(search);
        return classSearchVoList;
    }

    @GetMapping("/file")
    @ResponseBody
    public String saveUrlAs(Integer id, HttpServletResponse response) {

        Doc doc = iDocService.findDoc(id);
        String fileName = doc.getName();
        File file = new File(doc.getPath());

        try {
            InputStream fis = new BufferedInputStream(new FileInputStream(doc.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/force-download");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "success";
    }
}
