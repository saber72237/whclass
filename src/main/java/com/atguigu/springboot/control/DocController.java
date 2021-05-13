package com.atguigu.springboot.control;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springboot.bean.Class;
import com.atguigu.springboot.bean.Doclist;
import com.atguigu.springboot.bean.Vo.ClassDocVo;
import com.atguigu.springboot.bean.Vo.ClassSearchVo;
import com.atguigu.springboot.service.ClassService;
import com.atguigu.springboot.service.IDocService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    @GetMapping("/docList")
    public String list(Model model, HttpSession session){
        Collection<Doclist> doclists = iDocService.findById((Integer) session.getAttribute("id"));
        model.addAttribute("emps",doclists);
        return "emp/doc";
    }

    @GetMapping("/list/{prefixId}")
    public String docList(Model model, @PathVariable String prefixId){
        List<ClassDocVo> doclists = iDocService.getList(prefixId);
        List<ClassDocVo> classDocs = iDocService.getDocList(prefixId);
        doclists.addAll(classDocs);
        model.addAttribute("emps",doclists);
        return "emp/doc";
    }

    @PostMapping("/add")
    public String add(@RequestBody Doclist doclist, HttpSession session){
        Boolean classVos = iDocService.addById(doclist);
        return "emp/doc";
    }

    @PostMapping("/editPassword")
    public String editPassword(@RequestBody Doclist doclist){
            if (StrUtil.isEmpty(doclist.getPath())){
                Boolean classDocVo1 = iDocService.editPassword1(doclist.getId(), doclist.getPassword());
            }
            else {
                Boolean classDocVo2 = iDocService.editPassword2(doclist.getId(), doclist.getPassword());
            }
        return "emp/doc";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpSession session,
                     @RequestParam(value = "doclist", required = false) String doc){
        Integer id = (Integer) session.getAttribute("id");
        Doclist doclist = new Doclist();
        doclist = JSONObject.parseObject(doc, Doclist.class);
        doclist.setTeacherId(id);
        if (StrUtil.isNotEmpty(doclist.getName())){
            Boolean classVos = iDocService.addById(doclist);
            return "emp/doc";
        }
        Path path = null;
        String name = null;
        try {
            byte[] bytes = file.getBytes();
            path = Paths.get("/usr/src/whclass" + file.getOriginalFilename());
            name = file.getOriginalFilename();
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        doclist.setPath(path.toString());
        doclist.setName(name);
        iDocService.saveDoclist(doclist);
        return "emp/doc";
    }

    @PostMapping("/update")
    public String update(@RequestBody Doclist doclist){
        Boolean classVos = iDocService.updateById(doclist);
        return "emp/doc";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Boolean classVos = iDocService.deleteById(id);
        return "redirect:http://localhost:8080/crud/class/emps";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Doclist> classSearch(String search){
        List<Doclist> classSearchVoList = new ArrayList<Doclist>();
        classSearchVoList = iDocService.findByName(search);
        return classSearchVoList;
    }
}
