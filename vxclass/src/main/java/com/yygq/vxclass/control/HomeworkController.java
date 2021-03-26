package com.yygq.vxclass.control;

import com.alibaba.fastjson.JSONObject;
import com.yygq.vxclass.bean.Doclist;
import com.yygq.vxclass.bean.File;
import com.yygq.vxclass.bean.Homework;
import com.yygq.vxclass.service.FileService;
import com.yygq.vxclass.service.HomeworkService;
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
 * @author ：xxx
 * @description：TODO
 * @date ：2021/1/3 14:12
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;

    @Autowired
    FileService fileService;

    @GetMapping("/stuClass")
    @ResponseBody
    public List<Homework> stuClass(Integer classId){
        classId = 1;
        List<Homework> homeworkList = new ArrayList<Homework>();
        homeworkList = homeworkService.findByClassId(classId);
        return homeworkList;
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        Path path = null;
        try {
            byte[] bytes = file.getBytes();
            path = Paths.get("/Users/admin/Desktop/whclass/" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path.toString();
    }

    @GetMapping("/save")
    public Boolean save(HttpSession httpSession, @RequestParam(value = "path", required = false) String path,
                          @RequestParam(value = "homeworkId", required = false) String homeworkId){
        //String stuId = String.valueOf(httpSession.getAttribute("id"));
        String stuId = "1";
        File homework = new File();
        homework.setAdress(path);
        homework.setHomeworkId(Integer.valueOf(homeworkId));
        homework.setStudentId(Integer.valueOf(stuId));
        fileService.saveHomework(homework);
        return true;
    }

    @GetMapping("/detail")
    @ResponseBody
    public Homework detail(Integer id){
        Homework homework = new Homework();
        homework = homeworkService.findById(id);
        return homework;
    }

}
